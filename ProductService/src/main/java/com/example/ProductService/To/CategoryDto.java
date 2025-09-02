package com.example.ProductService.To;

import java.time.Instant;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {
	private String name;
	private Long id;
	private Instant createdOn;
	private Instant updatedOn;
	private List<ProductTo> productList;
}
