package com.example.ProductService.Mapper;

import java.util.ArrayList;
import java.util.List;

import com.example.ProductService.Entity.Category;
import com.example.ProductService.Entity.Product;
import com.example.ProductService.To.CategoryDto;
import com.example.ProductService.To.ProductTo;

public class CategoryMapper {
	public static Category toCategory(CategoryDto categoryTo) {
		return Category.builder()
				.name(categoryTo.getName())
				.build();
	}
	
	public static CategoryDto toCategoryDto(Category category) {
		List<ProductTo> productList = new ArrayList<ProductTo>();
		for(Product p : category.getProducts()) {
			productList.add(ProductMapper.toProductTo(p));
		}
		return CategoryDto.builder()
				.name(category.getName())
				.id(category.getId())
				.createdOn(category.getCreatedOn())
				.updatedOn(category.getUpdatedOn())
				.productList(productList)
				.build();
	}
}
