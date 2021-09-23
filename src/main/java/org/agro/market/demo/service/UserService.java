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


    //List<User> allUsers();

	User updateShoppingCart(String idUser, List<Product> products) throws UserNotFoundException;

    User findByEmail(String email );

    User updateById(UserDto userDto, String id);

    boolean deleteById(String id);


    User putProductInShoppingCart(String userId, String productId);

    Boolean deleteProductFromShoppingCart(String userId, String productId);


    List<Product> getProductsOfShoppingCart(String userId);
}
