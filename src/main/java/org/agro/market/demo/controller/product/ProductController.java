package org.agro.market.demo.controller.product;

import org.agro.market.demo.controller.product.dto.ProductDto;
import org.agro.market.demo.repository.document.Product;
import org.agro.market.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(@Autowired ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product create(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable String id) {
        return productService.findProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/name/{name}")
    public List<Product> findProductsByname(@PathVariable String name) {
        return productService.findProductsByname(name);
    }

    @PutMapping("/{id}")
    public Product updateProductById(@RequestBody ProductDto productDto, @PathVariable String id) {
        return productService.updateProductById(productDto, id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProductById(@PathVariable String id) {
        return productService.deleteProductById(id);
    }

}
