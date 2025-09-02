package com.example.OrderService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OrderService.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
