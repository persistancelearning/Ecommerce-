package com.onebox.ecommerce.cartapi.entity;

import java.io.Serializable;

public class Product implements Serializable {

	private int id;
	private String description;
	private int amount;

	public Product() {

	}

	public Product(int id, String description, int amount) {
		this.id = id;
		this.description = description;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Product [amount=" + amount + ", description=" + description + ", id=" + id + "]";
	}

}

