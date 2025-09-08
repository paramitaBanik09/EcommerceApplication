package com.example.ProductService.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ProductService.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	@Query("select p from Product p where p.name like %:str%")
	public Page<Product> searchProductByName(@Param(value = "str") String str,Pageable pageable);
}
