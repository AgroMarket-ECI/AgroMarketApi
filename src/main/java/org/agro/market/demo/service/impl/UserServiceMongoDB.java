package org.agro.market.demo.service.impl;

import org.agro.market.demo.controller.user.dto.UserDto;
import org.agro.market.demo.exception.InvalidCredentialsException;
import org.agro.market.demo.exception.ProductNotFoundException;
import org.agro.market.demo.exception.UserNotFoundException;
import org.agro.market.demo.repository.ProductRepository;
import org.agro.market.demo.repository.UserRepository;
import org.agro.market.demo.repository.document.Product;
import org.agro.market.demo.repository.document.User;
import org.agro.market.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceMongoDB
        implements UserService {

	private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository, @Autowired ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    //User (User - Provider)
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
 /**   @Override
    public User findByEmail(String email) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new UserNotFoundException();
        }
    }**/


    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Override
    public User findById(String id){
        Optional<User> optional = userRepository.findById(id);
        if ( optional.isPresent() ){
            return optional.get();
        } else {
            throw new ProductNotFoundException();
        }
    }

    
    @Override
    public User updateById(UserDto userDto, String id){
        User user = null;
        if(userRepository.existsById(id)){
            user = userRepository.findById(id).get();
            user.update(userDto);
            userRepository.save(user);
        }
        return user;
    }

    @Override
    public User updateShoppingCart(String idUser,List<Product> products) throws UserNotFoundException{
        User user= (User) findById(idUser);
        user.setShoppingCart(products);
        return userRepository.save(user);
    }

    public boolean deleteById(String id) {
        boolean deleted = false;
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            deleted =true;
        }
        return deleted;
    }


    //ShoppingCart
    @Override
    public User putProductInShoppingCart(String userId, String productId) {
        User User = null;
        if(userRepository.findById(userId).isPresent() && productRepository.findById(productId).isPresent()){
            User = userRepository.findById(userId).get();
            List <Product> shoppingCart = User.getShoppingCart();
            shoppingCart.add(productRepository.findById(productId).get());
            userRepository.save(User);
        }
        return User;
    }

    @Override
    public Boolean deleteProductFromShoppingCart(String userId, String productId) {
        boolean deleted = false;
        User User = null;
        if(userRepository.existsById(userId)){
            User = (User)userRepository.findById(userId).get();
            List <Product> shoppingCart = User.getShoppingCart();
            shoppingCart.removeIf(product -> product.getId().equals(productId));
            userRepository.save(User);
            deleted = true;
        }
        return deleted;
    }

    public List<Product> getProductsOfShoppingCart(String userId) {
        List<Product> productList = new ArrayList<>();
        if(userRepository.existsById(userId)){
            User user = (User) userRepository.findById(userId).get();
            productList = user.getShoppingCart();
        }
        return productList;
    }
}
