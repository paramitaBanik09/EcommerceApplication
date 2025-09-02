package com.example.ProductService.Mapper;

import com.example.ProductService.Entity.Category;
import com.example.ProductService.To.CategoryDto;

public class CategoryMapper {
	public static Category toCategory(CategoryDto categoryTo) {
		return Category.builder()
				.name(categoryTo.getName())
				.build();
	}
	
	public static CategoryDto toCategoryDto(Category category) {
		return CategoryDto.builder()
				.name(category.getName())
				.id(category.getId())
				.createdOn(category.getCreatedOn())
				.updatedOn(category.getUpdatedOn())
				.build();
	}
}
