package org.agro.market.demo.controller.product.dto;

public class ItemDto {

    String idProduct;

    Integer quantity;

    public ItemDto(){

    }
    public ItemDto(String idProduct, Integer quantity) {
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public String getId() {
        return idProduct;
    }

    public void setId(String id) {
        this.idProduct = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
