package org.agro.market.demo.utils;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public interface Constants
{
    String COOKIE_NAME = "eci-JWT";

    String CLAIMS_ROLES_KEY = "eci_roles";

    int TOKEN_DURATION_MINUTES = 1440;

    String ADMIN_ROLE = "ADMIN";
    String USER_ROLE = "USER";
    String CLIENT_ROLE = "CLIENT";
    String PROVIDER_ROLE = "PROVIDER";

    List<String> products = new ArrayList();
    //products.add();
   //rrayList<String> cities_AL = new ArrayList<>(Arrays.asList("Amsterdam", "Paris", "London"));
}