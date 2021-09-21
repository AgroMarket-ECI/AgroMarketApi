package org.agro.market.demo.repository;

import org.agro.market.demo.repository.document.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String>{

}
