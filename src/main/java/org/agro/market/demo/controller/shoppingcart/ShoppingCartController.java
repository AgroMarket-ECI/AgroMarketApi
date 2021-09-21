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
	//@PutMapping("product/{id}")
	/*public List<User> putProductInShoppingCart (@RequestBody productDto, @PathVariable String id){
	 	ProductDto productDto = new ProductDto("Fertox Insecticida 300ml", 15.900,"Es para matar insectos en plantas", "Fertox",false,"FertoxInsecticida300ml.jpg");
        Product product = new Product(productDto);
		return userService.putProductInShoppingCart(product, id);
	}*/

	//@DeleteMapping("product/{id}")
	/*public Boolean deleteProductFromShoppingCart (@PathVariable String id){
		return userService.deleteProductFromShoppingCart(id);
	}*/
}
