package org.agro.market.demo.controller.order;

import org.agro.market.demo.controller.order.dto.OrderDto;
import org.agro.market.demo.repository.document.Order;
import org.agro.market.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/v1/order" )
public class OrderController {
	
	private final OrderService orderService;

	public OrderController( @Autowired OrderService orderService ){
	        this.orderService = orderService;
	}

	@PostMapping()
	public Order generateOrder(@RequestBody OrderDto orderDto){
		return orderService.generateOrder(orderDto);
	}
}
