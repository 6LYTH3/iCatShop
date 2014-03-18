package com.blythe;

public class Product {

	private String name;
	private double price = 100.00;
	private ProductService productService = new ProductImp();

	public Product() {
		// Default Constructor
	}

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPriceByName(String name) {
		return productService.getPriceByProduct(name);
	}

	public boolean isProduct(String name) {
		return productService.getProductByName(name) != null;
	}

	public void save() {
		if (!isProduct(name))
			productService.addProduct(name, price);
	}

	public void update(String name, double price) {
		productService.updateProduct(name, price);
	}

	public void delete(String name) {
		productService.delectProudct(name);
	}

}
