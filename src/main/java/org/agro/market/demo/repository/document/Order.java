package org.agro.market.demo.repository.document;

import org.agro.market.demo.controller.order.dto.OrderDto;
import org.agro.market.demo.controller.product.dto.ItemDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class Order {
    @Id
    String id;

    List<ItemDto> items;

    String idClient;

    Double totalValue;

    OrderStatus status;

    Date createdAt;

    public Order(){

    }

    public Order(String id, List<ItemDto> items, String idClient, Double totalValue, OrderStatus status, Date createdAt) {
        this.id = id;
        this.items = items;
        this.idClient = idClient;
        this.totalValue = totalValue;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Order (OrderDto orderDto){
        this.items = orderDto.getItems();
        this.idClient = orderDto.getIdClient();
        this.totalValue = totalValue;
        this.status = OrderStatus.PENDING;
        this.createdAt = new Date();
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        idClient = idClient;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
