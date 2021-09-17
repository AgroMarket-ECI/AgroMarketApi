package org.agro.market.demo.repository.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document
public class User
{
    @Id
    String id;

    @Indexed( unique = true )
    String email;

    List<RoleEnum> roles;

    String passwordHash;

    public User() {
    	
    }



    public String getId()
    {
        return id;
    }

    public String getPasswordHash()
    {
        return passwordHash;
    }

    public List<RoleEnum> getRoles()
    {
        return roles;
    }
}
