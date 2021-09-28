package org.agro.market.demo.service;

import java.util.List;

import org.agro.market.demo.controller.user.dto.UserDto;
import org.agro.market.demo.exception.UserNotFoundException;
import org.agro.market.demo.repository.document.User;
import org.agro.market.demo.repository.document.Product;

public interface UserService
{
	User create(UserDto userDto);

    List<User> getAll();

    User findById(String id);

    User findByEmail(String email );

    User updateById(UserDto userDto, String id);

    boolean deleteById(String id);
}
