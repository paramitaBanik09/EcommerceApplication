package com.example.OrderService.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OrderService.Service.OrderService;
import com.example.OrderService.To.OrderTo;

@RestController
@RequestMapping("/order/api/v1")
public class OrderController {
	OrderService orderService;
	OrderController(OrderService orderService){
		this.orderService=orderService;
	}
	
	@PostMapping
	public OrderTo createOrder(@RequestBody OrderTo orderTo) {
		return orderService.createOrder(orderTo);
	}
}
