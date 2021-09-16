package org.agro.market.demo.repository;

import org.agro.market.demo.repository.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository
    extends MongoRepository<User, String>
{
}
