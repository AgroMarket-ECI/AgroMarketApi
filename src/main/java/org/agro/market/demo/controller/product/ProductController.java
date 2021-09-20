package org.agro.market.demo.controller.product;

import org.agro.market.demo.controller.product.dto.ProductDto;
import org.agro.market.demo.repository.document.Product;
import org.agro.market.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<Product> getAllProducts(){
	    return productService.getAllProducts();
    }

    @PutMapping("/{id}")
	public Product updateProdcutById(ProductDto productDto, String id){
		return productService.updateProductById(productDto,id);
	}

	@DeleteMapping("/{id}")
	public boolean deleteProductById(String id){
		return productService.deleteProductById(id);
	}

	
	
	
}
