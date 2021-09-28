package org.agro.market.demo.repository;

import org.agro.market.demo.repository.document.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}
