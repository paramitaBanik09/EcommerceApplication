package com.example.ProductService.Entity;

import com.example.ProductService.Constant.ProductSize;
import com.example.ProductService.Constant.ProductType;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(indexes = @Index(columnList = "name",name = "product_name_inx"))
public class Product extends BaseEntity {
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
	
	@ManyToOne()
	@JoinColumn(name = "category_id")
	private Category category;
}
