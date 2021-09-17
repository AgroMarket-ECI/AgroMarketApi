package org.agro.market.demo.service;


import org.agro.market.demo.repository.document.User;

public interface UserService
{
    User findByEmail(String email );

}
