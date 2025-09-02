package com.example.ProductService.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Category extends BaseEntity{
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<Product> products; 
}
