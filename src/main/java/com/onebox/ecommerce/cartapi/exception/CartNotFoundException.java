package com.onebox.ecommerce.cartapi.exception;

public class CartNotFoundException extends RuntimeException {

	public CartNotFoundException() {
		super("Cart not found");
	}

	public CartNotFoundException(int id) {
		super(String.format("Cart with id %d not found", id));
	}

}

