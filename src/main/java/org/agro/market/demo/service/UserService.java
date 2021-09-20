package org.agro.market.demo.service;


import org.agro.market.demo.controller.user.dto.UserDto;
import org.agro.market.demo.repository.document.User;

import java.util.List;

public interface UserService
{
    User create( UserDto userDto );

    User findByEmail(String email );

    List<User> all();
}
