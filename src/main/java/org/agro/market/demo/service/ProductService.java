package org.agro.market.demo.service;

import org.agro.market.demo.controller.product.dto.ProductDto;
import org.agro.market.demo.repository.document.Product;

public interface ProductService {

	Product createProduct(ProductDto productDto);

	Product findProductById(String id);

}
