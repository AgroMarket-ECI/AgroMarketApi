package org.agro.market.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.agro.market.demo.controller.auth.LoginDto;
import org.agro.market.demo.controller.auth.TokenDto;
import org.agro.market.demo.controller.user.dto.UserDto;
import org.agro.market.demo.exception.InvalidCredentialsException;
import org.agro.market.demo.repository.document.User;
import org.agro.market.demo.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    UserService userService;

    @Test
    public void shouldReturnTokenNotnull() throws Exception {
        UserDto userDto = new UserDto("marcos.chia@mail.escuelaing.edu.co", "La_prueb4", "C");
        User user = new User(userDto);
        when(userService.findByEmail("marcos.chia@mail.escuelaing.edu.co")).thenReturn(user);

        LoginDto loginDto = new LoginDto("marcos.chia@mail.escuelaing.edu.co", "La_prueb4");
        String url = "http://localhost:" + port + "/v1/auth";

        TokenDto response = this.restTemplate.postForObject(url, loginDto, TokenDto.class);
        assertNotNull(response);
    }

    @Test
    public void shouldReturnTokenNull() throws Exception {
        when(userService.findByEmail("pablo.chia@mail.escuelaing.edu.co")).thenReturn(null);

        LoginDto loginDto = new LoginDto("pablo.chia@mail.escuelaing.edu.co", "s0l");
        String url = "http://localhost:" + port + "/v1/auth";

        Assertions.assertThrows(ResourceAccessException.class, () -> {
            this.restTemplate.postForObject(url, loginDto , TokenDto.class);
        });
    }
}
