package com.example.ProductService.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ProductService.Entity.Category;
import com.example.ProductService.Exceptions.NotFoundException;
import com.example.ProductService.Mapper.CategoryMapper;
import com.example.ProductService.Repository.CategoryRepository;
import com.example.ProductService.To.CategoryDto;

@Service
public class CategoryService {
	CategoryRepository categoryRepo;
	
	CategoryService(CategoryRepository categoryRepo){
		this.categoryRepo = categoryRepo;
	}
	
	public CategoryDto createCategory(CategoryDto catDto) {
		Category cat = CategoryMapper.toCategory(catDto);
		cat = categoryRepo.save(cat);
		return CategoryMapper.toCategoryDto(cat);
	}
	
	public List<CategoryDto> getListOfCategory(){
		List<CategoryDto> catList = new ArrayList<CategoryDto>();
		List<Category> cat = categoryRepo.findAll();
		
		for(Category c : cat) {
			if(c!=null) {
				catList.add(CategoryMapper.toCategoryDto(c));
			}
		}
		return catList;
		}
	
	public CategoryDto getCategoryById(Long id) {
		Category cat = categoryRepo.findById(id).orElseThrow(()-> new NotFoundException("Category not found with given ID " + id));
		return CategoryMapper.toCategoryDto(cat);
	}
}
