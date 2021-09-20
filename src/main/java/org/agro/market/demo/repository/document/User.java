package org.agro.market.demo.repository.document;

import org.agro.market.demo.controller.user.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.management.relation.Role;
import java.util.*;

@Document
public class User {
    @Id
    String id;

    @Indexed(unique = true)
    String email;

    List<RoleEnum> roles;

    String passwordHash;

    Date createdAt;

    public User() {

    }

    public User(UserDto userDto) {
        email = userDto.getEmail();
        createdAt = new Date();
        roles = new ArrayList<>(Collections.singleton(getRole(userDto.getRol())));
        passwordHash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt()); //password encryption
    }

    public String getId() {
        return id;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public List<RoleEnum> getRoles() {
        return roles;
    }

    public RoleEnum getRole(String role) {

        if (role.equals("C")) {
            return RoleEnum.CLIENT;
        } else if (role.equals("P")) {
            return RoleEnum.PROVIDER;
        } else{
            throw new InputMismatchException("Invalid user role!");
        }
    }
}
