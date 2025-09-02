package com.example.OrderService.Mapping;

import java.util.ArrayList;
import java.util.List;

import com.example.OrderService.Entity.Order;
import com.example.OrderService.Entity.OrderItem;
import com.example.OrderService.To.OrderItemsTo;
import com.example.OrderService.To.OrderTo;

public class OrderMapping {
	public static Order toOrder(OrderTo orderTo) {
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		for(OrderItemsTo orderItemTo : orderTo.getOrderItemsTo()) {
			orderItemList.add(OrderItemsMapping.toOrderItem(orderItemTo));
		}
		return Order.builder()
				.status(orderTo.getStatus())
				.userId(orderTo.getUserId())
				.orderItems(orderItemList).build();
	}
	
	public static OrderTo toOrderTo(Order order) {
		List<OrderItemsTo> orderItemTo = new ArrayList<OrderItemsTo>();
		for(OrderItem orderItem : order.getOrderItems()) {
			orderItemTo.add(OrderItemsMapping.toOrderItemsTo(orderItem));
		}
		return OrderTo.builder()
				.createdOn(order.getCreatedOn())
				.id(order.getId())
				.status(order.getStatus())
				.updatedOn(order.getUpdatedOn())
				.userId(order.getUserId())
				.orderItemsTo(orderItemTo).build();
	}
}
