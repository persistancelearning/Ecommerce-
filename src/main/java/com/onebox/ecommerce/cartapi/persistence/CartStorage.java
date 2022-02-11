package com.onebox.ecommerce.cartapi.persistence;

import java.util.HashMap;

import com.onebox.ecommerce.cartapi.entity.Cart;

import org.springframework.stereotype.Component;

@Component
public class CartStorage extends HashMap<Integer, Cart> {

	@Override
	public Cart put(Integer id, Cart cart) {

		if (id == null) {
			cart = generateId(cart);
		}

		return super.put(cart.getId(), cart);

	}

	private Cart generateId(Cart cart) {
		cart.setId(super.size() + 1);
		return cart;
	}

}

