package com.example.OrderService.To;

import java.time.Instant;

import com.example.OrderService.Entity.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemsTo {
	private Long id;
	private Instant createdOn;
	private Instant updatedOn;
	private Long productId;
	private Long quantity;
	private double ricePerUnit;
	private double otalPrice;
	private Long orderId;
}
