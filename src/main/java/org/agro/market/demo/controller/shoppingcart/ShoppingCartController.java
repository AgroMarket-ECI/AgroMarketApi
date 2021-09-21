package org.agro.market.demo.controller.shoppingcart;

import org.agro.market.demo.service.ProductService;
import org.agro.market.demo.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.agro.market.demo.repository.document.Product;

@RestController
@RequestMapping( "/v1/user/shoppingCart" )
public class ShoppingCartController {
	
	private final ShoppingCartService shoppingCartService;

	public ShoppingCartController( @Autowired ShoppingCartService shoppingCartService ){
	        this.shoppingCartService = shoppingCartService;
	}

	@GetMapping
	public List<Product> getProductsOfShoppingCart(){
		//return ShoppingCartService.getProductsOfShoppingCart();
		return null;
	}
	
	
	

}
