package com.example.OrderService.ProductClient;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.OrderService.To.ProductTo;

@Component
public class ProductClient {
	//RestTemplateBuilder restTempBuilder;
	
	/*
	 * ProductClient(RestTemplateBuilder restTempBuilder){
	 * this.restTempBuilder=restTempBuilder; }
	 */
	RestTemplate restTemplate;
	ProductClient(RestTemplate restTemplate){
		this.restTemplate = restTemplate;
	}
	public ResponseEntity<List<ProductTo>> getProductListByIds(List<Long> ids) {
		StringBuilder stringBuilder = new StringBuilder();
		for(Long l : ids) {
			stringBuilder.append(l+",");
		}
		String url = "http://PRODUCTSERVICE/product/api/v1/ByidList?ids=" + stringBuilder.substring(0, stringBuilder.length()-1);
		//RestTemplate restTemp = restTempBuilder.build();
		//ResponseEntity<List<ProductTo>> productList = restTemp.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<List<ProductTo>>() {});
		ResponseEntity<List<ProductTo>> productList = this.restTemplate.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<List<ProductTo>>() {});
		return productList;
	}
}
