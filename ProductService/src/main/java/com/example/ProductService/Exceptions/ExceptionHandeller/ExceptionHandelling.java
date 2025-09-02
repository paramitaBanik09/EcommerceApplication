package com.example.ProductService.Exceptions.ExceptionHandeller;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.ProductService.Exceptions.MandetoryFieldMissingException;
import com.example.ProductService.Exceptions.NotFoundException;
import com.example.ProductService.Exceptions.ErrorMessage.ErrorMsg;

@ControllerAdvice
public class ExceptionHandelling {
	
	@ExceptionHandler
	public ResponseEntity<ErrorMsg> categoryNotFoundException(NotFoundException exp) {
		ErrorMsg err = new ErrorMsg();
		err.setMsg(exp.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND);
		err.setStatusCode(HttpStatus.NOT_FOUND.value());
		err.setTime(Instant.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(err);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorMsg> mandetoryFieldValidation(MandetoryFieldMissingException exp){
		ErrorMsg err = new ErrorMsg();
		err.setMsg(exp.getMessage());
		err.setStatus(HttpStatus.BAD_REQUEST);
		err.setStatusCode(HttpStatus.BAD_REQUEST.value());
		err.setTime(Instant.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(err);
	}
}
