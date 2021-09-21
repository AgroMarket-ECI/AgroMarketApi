package org.agro.market.demo.controller.shoppingcart;

import org.agro.market.demo.service.ProductService;
import org.agro.market.demo.service.ShoppingCartService;
import org.agro.market.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.agro.market.demo.repository.document.Product;

@RestController
@RequestMapping( "/v1/shoppingCart" )
public class ShoppingCartController {
	
	private final UserService userService;

	public ShoppingCartController( @Autowired UserService userService ){
	        this.userService = userService;
	}
	
	@PutMapping
	public List<Product> updateShoppingCart(List<Product> products){
		return userService.updateShoppingCart(products);
	}
	
	

}
