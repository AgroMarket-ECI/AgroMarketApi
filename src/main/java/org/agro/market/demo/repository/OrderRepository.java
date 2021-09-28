package org.agro.market.demo.repository;

import org.agro.market.demo.repository.document.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {

}
