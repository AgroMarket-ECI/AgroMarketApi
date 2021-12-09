package org.agro.market.demo.repository.document;

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
	private String idProvider;
	private double taxes;
	private boolean favorite;
	private String image;

	public Product() {

	}

	public Product(String id) {
		this.id = id;
	}
	
	public Product(ProductDto productdto) {
		this.name = productdto.getName();
		this.price = productdto.getPrice();
		this.description = productdto.getDescription();
		this.idProvider = productdto.getIdProvider();
		this.taxes = 0.19;
		this.favorite = productdto.isFavorite();
		this.image = productdto.getImage();
	}

	public Product(String name, double price, String description, String idProvider, boolean favorite, String image) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.idProvider = idProvider;
		this.favorite = favorite;
		this.taxes = 0.19;
		this.image = image;
	}

	public void update(ProductDto productDto){
		this.name = productDto.getName();
		this.price = productDto.getPrice();
		this.description = productDto.getDescription();
		this.idProvider = productDto.getIdProvider();
		this.favorite = productDto.isFavorite();
		this.taxes = 0.19;
		this.image = productDto.getImage();
	}

	public double calculatePriceWithTaxes(){
		return (this.price * taxes) + this.price;
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

	public String getIdProvider() {
		return idProvider;
	}

	public void setIdProvider(String IdProvider) {
		this.idProvider = idProvider;
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

	public double getTaxes() {
		return taxes;
	}
}
