package com.blythe;

public class Main {

	public static void main(String[] args) {
		Product p = new Product("n1", 10);
		p.save();

		Product product = new Product();
		System.out.println(product.getPriceByName("name2"));

		Order order = new Order("Naruedol", "n1", 2);
		//order.insertOrder();

		System.out.println(order.getOrder("Naruedol"));

		String nn = order.getOrder("Naruedol").get(0);
		String[] upOrder = nn.split(":");

		order.updateOrder(upOrder[0], upOrder[1], Double.valueOf(upOrder[2]),
				Integer.valueOf(upOrder[3]));

	}

}
