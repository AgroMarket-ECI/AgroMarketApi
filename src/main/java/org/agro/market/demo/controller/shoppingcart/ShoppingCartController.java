package org.agro.market.demo.controller.shoppingcart;

import org.agro.market.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.agro.market.demo.repository.document.Product;
import org.agro.market.demo.repository.document.User;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping( "/v1/shoppingCart" )
public class ShoppingCartController {
	
	private final UserService userService;

	public ShoppingCartController( @Autowired UserService userService ){
	        this.userService = userService;
	}

	@PutMapping("/{userId}/product/{productId}")
	public User putProductInShoppingCart (@PathVariable String userId, @PathVariable String productId){
		return userService.putProductInShoppingCart(userId, productId);
	}

	@GetMapping("/{userId}")
	public List<Product> getProductsOfShoppingCart(@PathVariable String userId){
		return userService.getProductsOfShoppingCart(userId);
	}

	@PutMapping("/{userId}")
	public User updateShoppingCart(@PathVariable String userId,@RequestBody List<Product> products){
		return userService.updateShoppingCart(userId,products);
	}
	
	@DeleteMapping("/{userId}/product/{productId}")
	public Boolean deleteProductFromShoppingCart (@PathVariable String userId, @PathVariable String productId){
		return userService.deleteProductFromShoppingCart(userId, productId);
	}
}
