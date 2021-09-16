package org.agro.market.demo.service;


import org.agro.market.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoUserService
    implements UserService
{

    private final UserRepository repository;

    public MongoUserService( @Autowired UserRepository repository )
    {
        this.repository = repository;
    }

   
}
