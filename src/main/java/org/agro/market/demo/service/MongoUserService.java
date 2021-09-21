package org.agro.market.demo.service;


import org.agro.market.demo.repository.UserRepository;
import org.agro.market.demo.repository.document.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoUserService implements UserService{

    private final UserRepository repository;

    public MongoUserService( @Autowired UserRepository repository )
    {
        this.repository = repository;
    }

	@Override
	public List<Product> updateShoppingCart(List<Product> products) {
		
		//User user=obtenerUsuario();
		//modificarUsuario
		return products;
		
	}

   
}
