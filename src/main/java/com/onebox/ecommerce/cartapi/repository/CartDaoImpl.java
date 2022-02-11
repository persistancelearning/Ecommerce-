package com.onebox.ecommerce.cartapi.repository;

import java.util.List;
import java.util.stream.Collectors;

import com.onebox.ecommerce.cartapi.entity.Cart;
import com.onebox.ecommerce.cartapi.exception.CartNotFoundException;
import com.onebox.ecommerce.cartapi.persistence.CartStorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	public CartStorage cartStorage;

	@Override
	public Cart create(Cart cart) {
		return cartStorage.put(null, cart);
	}

	@Override
	public Cart get(int id) {
		Cart cart = cartStorage.get(id);

		if (cart == null) {
			throw new CartNotFoundException(id);
		}

		return cart;
	}

	@Override
	public void delete(int id) {
		if (cartStorage.remove(id) == null) {
			throw new CartNotFoundException(id);
		}
	}

	@Override
	public List<Cart> findAll() {
			return cartStorage.values().stream().collect(Collectors.toList());
	}

}

