package org.agro.market.demo.service.impl;

import org.agro.market.demo.controller.user.dto.UserDto;
import org.agro.market.demo.exception.InvalidCredentialsException;
import org.agro.market.demo.exception.UserNotFoundException;
import org.agro.market.demo.repository.UserRepository;
import org.agro.market.demo.repository.document.Product;
import org.agro.market.demo.repository.document.User;
import org.agro.market.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceMongoDB
        implements UserService {

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository repository) {
        this.userRepository = repository;
    }

    @Override
    public User create(UserDto userDto) {
        if (userDto.getRol() != null) {
            return userRepository.save(new User(userDto));
        } else {
            throw new InvalidCredentialsException();
        }
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public List<User> all() {
        return userRepository.findAll();
    }

    @Override
    public List<Product> updateShoppingCart(List<Product> products) {

        //User user=obtenerUsuario();
        //modificarUsuario
        return products;

    }
}
