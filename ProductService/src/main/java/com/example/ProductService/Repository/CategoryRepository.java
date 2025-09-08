package com.example.ProductService.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ProductService.Entity.Category;
import com.example.ProductService.Entity.Product;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	@Query("select p from Category c join c.products p where c.id = :id")
	public Page<Product> getListOfProductByCategory(@Param(value = "id") Long id,Pageable pageable);
}
