package com.onebox.ecommerce.cartapi.exception;

import com.onebox.ecommerce.cartapi.response.CartErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CartExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CartErrorResponse> handleException(CartNotFoundException exc) {

		return new ResponseEntity<>(
				new CartErrorResponse(
						HttpStatus.NOT_FOUND.value(),
						exc.getMessage(),
						System.currentTimeMillis()
						),
				HttpStatus.NOT_FOUND);
	}
}

