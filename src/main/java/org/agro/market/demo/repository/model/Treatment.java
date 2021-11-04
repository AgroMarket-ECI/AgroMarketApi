package org.agro.market.demo.repository.model;

import org.agro.market.demo.repository.document.Product;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Treatment {
    @Id
    private String id;
    private String name;
    private String instructions;
    private List<Product> products;

    public Treatment() {
    }

    public Treatment(String id, String name, String instructions, List<Product> products) {
        this.id = id;
        this.name = name;
        this.instructions = instructions;
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

}