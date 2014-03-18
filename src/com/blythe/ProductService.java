package com.blythe;

import java.util.ArrayList;

public interface ProductService {
	public ArrayList<String> getOrderByName(String name);

	public ArrayList<String> showProduct();

	public void addCart(String username, String product, double price,
			int items, String status);

	public void updateCart(String username, String product, double price,
			int items, String status);

	public String getProductByName(String name);

	public Double getPriceByProduct(String name);

	public void addProduct(String name, double price);

	public void updateProduct(String name, double price);

	public void delectProudct(String name);
}
