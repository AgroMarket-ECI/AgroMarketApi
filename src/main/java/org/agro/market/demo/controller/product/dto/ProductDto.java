package org.agro.market.demo.controller.product.dto;

public class ProductDto {
	
	private String name;
	private double price;
	private String description;
	private String idProvider;
	private boolean favorite;
	private String image;
	
	public ProductDto(){
		
	}

	public ProductDto(String name, double price, String description, String idProvider, boolean favorite, String image) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.idProvider = idProvider;
		this.favorite = favorite;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public String getIdProvider() {
		return idProvider;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public String getImage() {
		return image;
	}

}
