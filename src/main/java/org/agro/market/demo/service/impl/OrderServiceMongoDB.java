package org.agro.market.demo.service.impl;

import org.agro.market.demo.controller.order.dto.OrderDto;
import org.agro.market.demo.repository.OrderRepository;
import org.agro.market.demo.repository.document.Order;
import org.agro.market.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceMongoDB implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceMongoDB(@Autowired OrderRepository orderRepository )
    {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order generateOrder(OrderDto orderDto) {
        return orderRepository.save(new Order(orderDto));
    }
}
