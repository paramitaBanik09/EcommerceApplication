package com.example.ProductService.Mapper;

import com.example.ProductService.Entity.Category;
import com.example.ProductService.Entity.Product;
import com.example.ProductService.To.ProductTo;

public class ProductMapper {
	public static ProductTo toProductTo(Product product) {
		return ProductTo.builder()
		.id(product.getId())
		.brand(product.getBrand())
		.clothsType(product.getClothsType())
		.color(product.getColor())
		.createdOn(product.getCreatedOn())
		.description(product.getDescription())
		.name(product.getName())
		.rating(product.getRating())
		.size(product.getSize())
		.updatedOn(product.getUpdatedOn())
		.price(product.getPrice())
		.categoryId(product.getCategory()!=null?product.getCategory().getId() : null)
		.build();
	}
	
	public static Product toProduct(ProductTo productTo,Category cat) {
		return Product.builder()
				.brand(productTo.getBrand())
				.clothsType(productTo.getClothsType())
				.color(productTo.getColor())
				.description(productTo.getDescription())
				.name(productTo.getName())
				.rating(productTo.getRating())
				.size(productTo.getSize())
				.price(productTo.getPrice())
				.category(cat)
				.build();
	}
}
