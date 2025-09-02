package com.example.OrderService.Mapping;

import com.example.OrderService.Entity.OrderItem;
import com.example.OrderService.To.OrderItemsTo;

public class OrderItemsMapping {
	public static OrderItem toOrderItem(OrderItemsTo orderItemTo) {
	return	OrderItem.builder()
		.totalPrice(orderItemTo.getOtalPrice())
		.productId(orderItemTo.getProductId())
		.quantity(orderItemTo.getQuantity())
		.pricePerUnit(orderItemTo.getRicePerUnit())
		//.order(OrderMapping.toOrder(orderItemTo.getOrderTo()))  //To avoid stackoverflow exception. If we do this then it will a circular dependencies.
		.build();
	}
	
	public static OrderItemsTo toOrderItemsTo(OrderItem orderItem) {
		return OrderItemsTo.builder()
		.id(orderItem.getId())
		//.orderTo(OrderMapping.toOrderTo(orderItem.getOrder()))
		.otalPrice(orderItem.getTotalPrice())
		.productId(orderItem.getProductId())
		.quantity(orderItem.getQuantity())
		.ricePerUnit(orderItem.getPricePerUnit())
		.updatedOn(orderItem.getUpdatedOn())
		.createdOn(orderItem.getCreatedOn())
		.orderId(orderItem.getOrder()!=null?orderItem.getOrder().getId():null)
		.build();
	}
}
