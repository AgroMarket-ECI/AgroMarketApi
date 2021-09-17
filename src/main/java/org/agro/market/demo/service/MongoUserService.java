package org.agro.market.demo.service;


import org.agro.market.demo.exception.UserNotFoundException;
import org.agro.market.demo.repository.UserRepository;
import org.agro.market.demo.repository.document.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MongoUserService
    implements UserService
{

    private final UserRepository repository;

    public MongoUserService( @Autowired UserRepository repository )
    {
        this.repository = repository;
    }


    @Override
    public User findByEmail(String email) {
        Optional<User> optionalUser = repository.findByEmail(email);
        if ( optionalUser.isPresent() )
        {
            return optionalUser.get();
        }
        else
        {
            throw new UserNotFoundException();
        }
    }
}
