package org.agro.market.demo.controller.shoppingcart;

import org.agro.market.demo.service.ProductService;
import org.agro.market.demo.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.agro.market.demo.repository.document.Product;

@RestController
@RequestMapping( "/v1/user/shoppingCart" )
public class ShoppingCartController {
	
	private final ShoppingCartService shoppingCartService;

	public ShoppingCartController( @Autowired ShoppingCartService shoppingCartService ){
	        this.shoppingCartService = shoppingCartService;
	}
	
	
	

}
