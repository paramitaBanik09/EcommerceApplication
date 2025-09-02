package com.example.ProductService.Exceptions;

public class MandatoryFieldMissingException extends RuntimeException{

	public MandatoryFieldMissingException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MandatoryFieldMissingException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public MandatoryFieldMissingException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MandatoryFieldMissingException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MandatoryFieldMissingException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
