package org.agro.market.demo.controller.order.dto;

import org.agro.market.demo.controller.product.dto.ItemDto;

import java.util.List;

public class OrderDto {

    String id;

    String idClient;

    String totalValue;

    List<ItemDto> items;

    public OrderDto(){

    }

    public OrderDto(String id, List<ItemDto> items) {
        this.id = id;
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(String totalValue) {
        this.totalValue = totalValue;
    }

}
