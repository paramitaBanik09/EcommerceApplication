package com.example.ProductService.Controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProductService.Service.CategoryService;
import com.example.ProductService.To.CategoryDto;
import com.example.ProductService.To.ProductTo;

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
	
	@GetMapping("/{id}/product")
	public Page<ProductTo> getListOdProductByCategoryInSortedOrder(@PathVariable(name = "id") Long id,
			@RequestParam(value="page") int page,@RequestParam(value="size") int size,@RequestParam(value="sort")String sort) {
		return catService.getListOfProductByCategoryInSortedOrder(id,page,size,sort);
	}
}
