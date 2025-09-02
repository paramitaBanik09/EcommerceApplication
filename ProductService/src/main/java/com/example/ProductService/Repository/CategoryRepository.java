package com.example.ProductService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProductService.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
