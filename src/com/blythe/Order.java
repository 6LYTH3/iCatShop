package com.blythe;

import java.util.ArrayList;

public class Order extends Product {
	private String username;
	private String productName;
	private int items;
	private ProductService productService = new ProductImp();

	public Order() {
		// Default Constructor
	}

	public Order(String username, String productName, int items) {
		this.username = username;
		this.productName = productName;
		this.items = items;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProductName() {
		return productName;
	}

	public void setProduct(String productName) {
		this.productName = productName;
	}

	public int getItems() {
		return items;
	}

	public void setItems(int items) {
		this.items = items;
	}

	public ArrayList<String> getOrder(String username) {
		return productService.getOrderByName(username);
	}

	public void insertOrder() {
		productService.addCart(username, productName,
				getPriceByName(productName), items, "Reserve");
	}

	public void updateOrder(String username, String productName, Double price,
			int items) {
		productService.updateCart(username, productName, price, items, "Offer");
	}
}
