package com.example.ProductService.Exceptions.ErrorMessage;

import java.time.Instant;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMsg {
	private String msg;
	private HttpStatus status;
	private Instant time;
	private int statusCode;
}
