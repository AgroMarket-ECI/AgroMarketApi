package org.agro.market.demo.service;

import org.agro.market.demo.controller.product.dto.ProductDto;
import org.agro.market.demo.repository.document.Product;
import java.util.List;

public interface ProductService {

	Product createProduct(ProductDto productDto);

	Product findProductById(String id);

    List<Product> findProductsByname(String name);
}
