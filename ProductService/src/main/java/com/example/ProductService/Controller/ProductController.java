package com.example.ProductService.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProductService.Service.ProductService;
import com.example.ProductService.To.ProductTo;

@RestController
@RequestMapping("/product/api/v1")
public class ProductController {

	ProductService prodService;

	ProductController(ProductService prodService) {
		this.prodService = prodService;
	}

	@PostMapping
	public ProductTo createProduct(@RequestBody ProductTo productTo) {
		return this.prodService.createProduct(productTo);
	}
	
	@GetMapping
	public List<ProductTo> getListOfProducts(){
		return prodService.getProductList();
	}
	
	@GetMapping("/ByidList")
	public List<ProductTo> getListOfProductByIds(@RequestParam(value = "ids") List<Long> ids){
		return prodService.getProductByIds(ids);
	}
}
