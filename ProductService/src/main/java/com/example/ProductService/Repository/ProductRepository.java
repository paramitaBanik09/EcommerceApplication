package com.example.ProductService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProductService.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
