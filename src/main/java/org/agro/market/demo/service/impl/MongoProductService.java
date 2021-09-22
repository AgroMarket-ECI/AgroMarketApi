package org.agro.market.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.agro.market.demo.controller.product.dto.ProductDto;
import org.agro.market.demo.exception.ProductNotFoundException;
import org.agro.market.demo.repository.ProductRepository;
import org.agro.market.demo.repository.document.Product;
import org.agro.market.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoProductService implements ProductService{
	
	private final ProductRepository productRepository;
	   
    public MongoProductService(@Autowired ProductRepository productRepository )
    {
        this.productRepository = productRepository;
    }

	@Override
	public Product createProduct(ProductDto productDto) {
        Product pr = new Product(productDto);
        Product rev = productRepository.save(pr);
		return rev;
	}

	@Override
	public Product findProductById(String id) {
		Optional<Product> optional = productRepository.findById(id);
        if ( optional.isPresent() ){
            return optional.get();
        } else {
            throw new ProductNotFoundException();
        }
	}

    @Override
    public List<Product> findProductsByname(String name){
        List<Product> productsByname = new ArrayList<>();
        List<Product> allProducts = productRepository.findAll();
        for (Product product : allProducts) {
            if (product.getName().contains(name)) {
                productsByname.add(product);
            }
        }
        return productsByname;
    }

	@Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Override
    public Product updateProductById(ProductDto productDto,String id) {
        Product product = null;
        if(productRepository.existsById(id)){
            product = productRepository.findById(id).get();
            product.update(productDto);
            productRepository.save(product);
        }
        return product;
    }

    @Override
    public boolean deleteProductById(String id) {
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
