package com.onebox.ecommerce.cartapi.controller;

import java.util.List;

import com.onebox.ecommerce.cartapi.entity.Cart;
import com.onebox.ecommerce.cartapi.entity.Product;
import com.onebox.ecommerce.cartapi.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	public CartService cartService;

	@GetMapping
	public ResponseEntity<String> createCart() {
		cartService.create();
		return ResponseEntity.ok("Created");
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cart> getCart(@PathVariable("id") Integer id) {
		Cart cart = cartService.get(id);
		return ResponseEntity.ok(cart);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCart(@PathVariable("id") Integer id) {
		cartService.delete(id);
		return ResponseEntity.ok("Deleted");
	}

	@PostMapping("/product/{id}")
	public ResponseEntity<Cart> addProduct(@PathVariable("id") Integer id, @RequestBody List<Product> products) {
		Cart cart = cartService.addProduct(id, products);
		return ResponseEntity.ok(cart);
	}

}
