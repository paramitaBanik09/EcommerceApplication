package com.example.ProductService.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProductService.Service.CategoryService;
import com.example.ProductService.To.CategoryDto;

@RestController
@RequestMapping("/category/api/v1/")
public class CategoryController {
	
	private CategoryService catService;
	
	CategoryController(CategoryService catService){
		this.catService=catService;
	}
	
	@PostMapping
	public CategoryDto createCategory(@RequestBody CategoryDto catDto) {
		return catService.createCategory(catDto);
	}
	
	@GetMapping
	public List<CategoryDto> getCategoryList(){
		return catService.getListOfCategory();
	}
}
