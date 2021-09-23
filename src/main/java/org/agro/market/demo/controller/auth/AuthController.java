package org.agro.market.demo.controller.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.agro.market.demo.exception.InvalidCredentialsException;
import org.agro.market.demo.exception.UserNotFoundException;
import org.agro.market.demo.repository.document.User;
import org.agro.market.demo.service.UserService;

import static org.agro.market.demo.utils.Constants.CLAIMS_ROLES_KEY;
import static org.agro.market.demo.utils.Constants.TOKEN_DURATION_MINUTES;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    @Value("${app.secret}")
    String secret;

    private final UserService userService;

    public AuthController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public TokenDto login(@RequestBody LoginDto loginDto) {

        try {
            User user = userService.findByEmail(loginDto.email);
            if (BCrypt.checkpw(loginDto.password, user.getPasswordHash())) {
                return generateTokenDto(user);
            } else {
                throw new InvalidCredentialsException();
            }
        } catch (UserNotFoundException | NullPointerException e) {
            throw new InvalidCredentialsException();
        }
    }

    private String generateToken(User user, Date expirationDate) {
        return Jwts.builder()
                .setSubject(user.getId())
                .claim(CLAIMS_ROLES_KEY, user.getRoles())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public TokenDto generateTokenDto(User user) {
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.add(Calendar.MINUTE, TOKEN_DURATION_MINUTES);
        String token = generateToken(user, expirationDate.getTime());
        return new TokenDto(token, expirationDate.getTime());
    }
}
