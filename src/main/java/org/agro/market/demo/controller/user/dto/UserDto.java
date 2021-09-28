package org.agro.market.demo.controller.user.dto;


public class UserDto
{
    String email;

    String password;

    String role;

    public UserDto()
    {
    }

    public UserDto(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public String getRole() {
        return role;
    }
}

