package org.agro.market.demo.service;

import java.util.List;

import org.agro.market.demo.controller.user.dto.UserDto;
import org.agro.market.demo.repository.document.User;
import org.agro.market.demo.repository.document.Product;

public interface UserService
{
    User create( UserDto userDto );

    User findByEmail(String email );

    List<Product> updateShoppingCart(List<Product> products);

    List<User> all();
}
