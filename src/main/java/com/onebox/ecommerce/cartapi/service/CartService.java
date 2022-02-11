package com.onebox.ecommerce.cartapi.service;

import java.util.Date;
import java.util.List;

import com.onebox.ecommerce.cartapi.entity.Cart;
import com.onebox.ecommerce.cartapi.entity.Product;
import com.onebox.ecommerce.cartapi.repository.CartDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

	@Autowired
	public CartDao cartDao;

	public Cart create() {
		Cart cart = new Cart();
		return cartDao.create(cart);
	}

	public Cart get(int id) {
		return cartDao.get(id);
	}

	public void delete(int id) {
		cartDao.delete(id);
	}

	public List<Cart> findAll() {
		return cartDao.findAll();
	}

	public Cart addProduct(int id, List<Product> products) {

		Cart cart = get(id);

		products.forEach(cart::addProduct);

		return cart;

	}

	public void deleteCartOverTimeToLive() {

		List<Cart> carts = findAll();

		carts.stream()
			.filter(cart -> ((new Date().getTime() / 60000) - (cart.getCreationDate().getTime() / 60000) > 1))
			.forEach((cart) -> delete(cart.getId()));

	}

}

