package org.agro.market.demo.controller.shoppingcart;

import org.agro.market.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.agro.market.demo.repository.document.Product;
import org.agro.market.demo.repository.document.User;

@RestController
@RequestMapping( "/v1/shoppingCart" )
public class ShoppingCartController {
	
	private final UserService userService;

	public ShoppingCartController( @Autowired UserService userService ){
	        this.userService = userService;
	}


	//@RolesAllowed("CLIENT")
	@GetMapping("{userId}")
	public List<Product> getProductsOfShoppingCart(@PathVariable String userId){
		return userService.getProductsOfShoppingCart(userId);
	}
	
	

	//@RolesAllowed("CLIENT")
	@PutMapping("/{userId}")
	public User updateShoppingCart(@PathVariable String userId,@RequestBody List<Product> products){
		return userService.updateShoppingCart(userId,products);


	}


	//@RolesAllowed("CLIENT")
	@PutMapping("{userId}/product/{productId}")
	public User putProductInShoppingCart (@PathVariable String userId, @PathVariable String productId){
		return userService.putProductInShoppingCart(userId, productId);
	}
	
	@DeleteMapping("{userId}/product/{productId}")
	//@RolesAllowed("CLIENT")
	public Boolean deleteProductFromShoppingCart (@PathVariable String userId, @PathVariable String productId){
		return userService.deleteProductFromShoppingCart(userId, productId);
	}
	

}
