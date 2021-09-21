package org.agro.market.demo.controller.product;

import org.agro.market.demo.controller.product.dto.ProductDto;
import org.agro.market.demo.repository.document.Product;
import org.agro.market.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping( "/v1/product" )
public class ProductController {

	private final ProductService productService;

	public ProductController( @Autowired ProductService productService ){
	        this.productService = productService;
	}
	
	@PostMapping
    public Product create( @RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }
	
	@GetMapping("/{id}")
    public Product findProductById( @PathVariable String id){
        return productService.findProductById(id);
    }

    @GetMapping("/name/{name}")
    public List<Product> findProductsByname(@PathVariable String name){ return productService.findProductsByname(name);
    }

	
}
