package com.onebox.ecommerce.cartapi.repository;

import java.util.List;

import com.onebox.ecommerce.cartapi.entity.Cart;

public interface CartDao {

	public Cart create(Cart cart);

	public Cart get(int id);

	public void delete(int id);

	public List<Cart> findAll();
}

