package com.example.ProductService.Service;

//import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

import com.example.ProductService.Entity.Category;
import com.example.ProductService.Entity.Product;
import com.example.ProductService.Exceptions.MandatoryFieldMissingException;
import com.example.ProductService.Exceptions.NotFoundException;
import com.example.ProductService.Mapper.ProductMapper;
import com.example.ProductService.Repository.CategoryRepository;
import com.example.ProductService.Repository.ProductRepository;
import com.example.ProductService.To.CategoryDto;
import com.example.ProductService.To.ProductTo;

@Service
public class ProductService {
	
	ProductRepository productRepo;
	CategoryRepository catRepo;
	
	ProductService(ProductRepository productRepo,CategoryRepository catRepo){
		this.productRepo=productRepo;
		this.catRepo = catRepo;
	}
	
	public ProductTo createProduct(ProductTo productTo) {
		if (productTo != null && productTo.getCategoryId() != null) {
			Category cat = catRepo.findById(productTo.getCategoryId()).orElseThrow(()-> new NotFoundException("Category not found with the given id "+productTo.getCategoryId()));
			Product prod = ProductMapper.toProduct(productTo,cat);
			Product outputProd = null;
			if (prod != null) {
				outputProd = productRepo.save(prod);
			}

			return ProductMapper.toProductTo(outputProd);
		} else {
			throw new MandatoryFieldMissingException("Category ID is a mandetory feild to create a product");
		}
	}
	
	public List<ProductTo> getProductList() {
		List<Product> prodList = productRepo.findAll();
		List<ProductTo> prodToList = new ArrayList<ProductTo>();
		for(Product prod : prodList) {
			prodToList.add(ProductMapper.toProductTo(prod));
		}
		return prodToList;
	}
	
	public List<ProductTo> getProductByIds(List<Long> ids){
		
		List<Product> productList = productRepo.findAllById(ids);
		List<ProductTo> productToList = new ArrayList<ProductTo>();
		for(Product pl : productList) {
			productToList.add(ProductMapper.toProductTo(pl));
		}
		
		return productToList;
	}
	
	public Page<ProductTo> getProductByName(String subStr,int page,int size){
		PageRequest pageable = PageRequest.of(page, size);
		Page<Product> prodList = productRepo.searchProductByName(subStr,pageable);
		List<ProductTo> prodTo = new ArrayList<ProductTo>();
		for(Product prod : prodList) {
			prodTo.add(ProductMapper.toProductTo(prod));
		}
		Page<ProductTo> pageOfProd = new PageImpl<ProductTo>(prodTo);
		return pageOfProd;
	}
}
