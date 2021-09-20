package org.agro.market.demo.controller.user.dto;


public class UserDto
{
    String email;

    String password;

    String rol;

    public UserDto()
    {
    }

    public UserDto(String email, String password, String rol) {
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public String getRol() {
        return rol;
    }
}

