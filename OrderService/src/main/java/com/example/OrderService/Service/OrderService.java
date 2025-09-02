package com.example.OrderService.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.OrderService.Entity.Order;
import com.example.OrderService.Entity.OrderItem;
import com.example.OrderService.Mapping.OrderMapping;
import com.example.OrderService.ProductClient.ProductClient;
import com.example.OrderService.Repository.OrderRepository;
import com.example.OrderService.To.OrderItemsTo;
import com.example.OrderService.To.OrderTo;
import com.example.OrderService.To.ProductTo;

@Service
public class OrderService {
	OrderRepository orderRepo;
	ProductClient productClient;
	OrderService(OrderRepository orderRepo,ProductClient productClient){
		this.orderRepo=orderRepo;
		this.productClient = productClient;
	}
	
	public OrderTo createOrder(OrderTo orderTo) {
		List<Long> ids = new ArrayList<Long>();
		if(orderTo!=null) {
		for(OrderItemsTo order : orderTo.getOrderItemsTo()) {
			ids.add(order.getProductId());
		}
		ResponseEntity<List<ProductTo>> resProductList = productClient.getProductListByIds(ids);
		if(resProductList!=null && resProductList.getBody()!=null) {
			List<ProductTo> productTo = resProductList.getBody();
			//Map<Long,ProductTo> prodMap = new HashMap<Long, ProductTo>();
			Map<Long,ProductTo> prodMap = new HashMap<>();
			for(ProductTo prodTo : productTo) {
				prodMap.put(prodTo.getId(), prodTo);
			}
			for(OrderItemsTo orderitem : orderTo.getOrderItemsTo()) {
				if(prodMap.containsKey(orderitem.getProductId())) {
					orderitem.setRicePerUnit(prodMap.get(orderitem.getProductId()).getPrice());
					orderitem.setOtalPrice(orderitem.getQuantity()*orderitem.getRicePerUnit());
					//orderitem.setOrderTo(orderTo);
				}
			}
			
			
		}
		
		Order order = OrderMapping.toOrder(orderTo);
		for(OrderItem orderItem : order.getOrderItems()) {
			orderItem.setOrder(order);
		}
		order.setStatus("Pending");
		return OrderMapping.toOrderTo(orderRepo.save(order));
		}
		return null;
	}
}
