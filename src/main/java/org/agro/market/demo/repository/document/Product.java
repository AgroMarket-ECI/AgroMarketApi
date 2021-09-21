package org.agro.market.demo.repository.document;

import java.util.UUID;

import org.agro.market.demo.controller.product.dto.ProductDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	
	@Id
	private String id;
	private String name;
	private double price;
	private String description;
	private String supplier;
	private boolean favorite;
	private String image;
	
	public Product() {
		
	}
	
	public Product(ProductDto productdto) {
		id = UUID.randomUUID().toString();
		this.name = productdto.getName();
		this.price = productdto.getPrice();
		this.description = productdto.getDescription();
		this.supplier = productdto.getSupplier();
		this.favorite = productdto.isFavorite();
		this.image = productdto.getImage();
	}
	public Product(String name, double price, String description, String supplier, boolean favorite, String image) {
		id = UUID.randomUUID().toString();
		this.name = name;
		this.price = price;
		this.description = description;
		this.supplier = supplier;
		this.favorite = favorite;
		this.image = image;
	}

	public void update(ProductDto productDto){
		this.name = productDto.getName();
		this.price = productDto.getPrice();
		this.description = productDto.getDescription();
		this.supplier = productDto.getSupplier();
		this.favorite = productDto.isFavorite();
		this.image = productDto.getImage();
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}