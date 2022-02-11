package com.onebox.ecommerce.cartapi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cart implements Serializable {

	private int id;
	private Date creationDate;
	private List<Product> products;

	public Cart() {
		this.creationDate = new Date();
	}

	public Cart(int id, Date creationDate, List<Product> products) {
		this.id = id;
		this.creationDate = creationDate;
		this.products = products;
	}

	public void addProduct(Product product) {

		if (products == null) {
			products = new ArrayList<>();
		}

		products.add(product);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Cart [creationDate=" + creationDate + ", id=" + id + ", products=" + products + "]";
	}

}

