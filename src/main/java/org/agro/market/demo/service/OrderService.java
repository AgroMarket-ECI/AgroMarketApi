package org.agro.market.demo.service;

import org.agro.market.demo.controller.order.dto.OrderDto;
import org.agro.market.demo.repository.document.Order;

public interface OrderService {
    Order generateOrder(OrderDto orderDto);
}
