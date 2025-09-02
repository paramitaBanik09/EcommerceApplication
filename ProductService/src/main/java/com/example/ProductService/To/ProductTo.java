package com.example.ProductService.To;

import java.time.Instant;

import com.example.ProductService.Constant.ProductSize;
import com.example.ProductService.Constant.ProductType;

import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductTo {
	private Long id;
	private Instant createdOn;
	private Instant updatedOn;
	private String name;
	private String color;
	private String description;
	
	@Enumerated
	private ProductSize size;
	private String rating;
	private String brand;
	
	@Enumerated
	private ProductType clothsType;
	
	private Long price;
	private Long categoryId;
}
