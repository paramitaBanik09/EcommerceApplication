package com.example.OrderService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class OrderItem extends BaseEntity{
	private Long productId;
	private Long quantity;
	private double pricePerUnit;
	private double totalPrice;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
}
