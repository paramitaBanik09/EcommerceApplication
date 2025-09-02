package com.example.OrderService.To;

import java.time.Instant;
import java.util.List;

import com.example.OrderService.Entity.OrderItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderTo {
	private Long id;
	private Instant createdOn;
	private Instant updatedOn;
	private Long userId;
	private String status;
	private List<OrderItemsTo> orderItemsTo;
}
