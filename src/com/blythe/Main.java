package com.blythe;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		Authentication authentication = new Authentication();
		System.out.println("------------[ Welcome To iCatShop ] ----------");
		System.out.println("[ Log In ]");
		System.out.print("User Name: ");
		String username = input.next();
		System.out.print("Password: ");
		String pw = input.next();
		if (authentication.validate(username, pw)) {
			int mode = -1;
			do {
				mode = getModeMain();
				switch (mode) {
				case 0:
					break;
				case 1:
					productMode();
					break;
				case 2:
					cartMode();
					break;
				case 3:
					System.out.println("-------[Register User]---------");
					System.out.print("User Name: ");
					String name = input.next();
					System.out.print("Password: ");
					String password = input.next();
					System.out.print("Role: ");
					String role = input.next();
					Register register = new Register();
					register.addUser(name, password, role);
				default:
					break;
				}

			} while (mode != 0);
		}

		System.out.println("-- Good Bye --");
	}

	private static void cartMode() {
		int mode = -1;
		Order order = new Order();
		do {
			mode = getModeCart();
			ArrayList<String> orderList = null;
			switch (mode) {
			case 0:
				break;
			case 1:
				System.out.println("-------[Order List]---------");
				System.out.print("Customer Name: ");
				String cName = input.next();
				orderList = order.getOrder(cName);
				for (String ol : orderList) {
					String[] o = ol.split(":");
					System.out.println(o[0] + " | " + o[1] + " | " + o[2]
							+ " | " + o[3] + " | " + o[4]);

				}
				break;
			case 2:
				System.out.println("-------[Create Order]---------");
				System.out.print("Customer Name: ");
				String cname = input.next();
				System.out.print("Product Name: ");
				String name = input.next();
				System.out.print("Product Items: ");
				int items = input.nextInt();
				Order x = new Order(cname, name, items);
				x.insertOrder();
				break;
			case 3:
				System.out.println("-------[Update Order]---------");
				Double total = 0.00;
				System.out.print("Customer Name: ");
				String uname = input.next();
				orderList = order.getOrder(uname);
				for (String lUpdate : orderList) {
					String[] oUpdate = lUpdate.split(":");
					order.updateOrder(oUpdate[0], oUpdate[1],
							Double.valueOf(oUpdate[2]),
							Integer.valueOf(oUpdate[3]));
					total += Double.valueOf(oUpdate[2])
							* Integer.valueOf(oUpdate[3]);
				}
				System.out.println("Pay total: " + total);
				break;
			case 9:
				System.out.println("-------[Product List]---------");
				Product product = new Product();
				ArrayList<String> productList = product.show();
				for (String pl : productList) {
					String[] p = pl.split(":");
					System.out.println(p[0] + " | " + p[1]);
				}
				break;
			default:
				break;
			}
		} while (mode != 0);
	}

	private static void productMode() {
		int mode = -1;
		Product product = new Product();
		do {
			mode = getModeProduct();
			switch (mode) {
			case 0:
				break;
			case 1:
				System.out.println("-------[Product List]---------");
				ArrayList<String> productList = product.show();
				for (String pl : productList) {
					String[] p = pl.split(":");
					System.out.println(p[0] + " | " + p[1]);
				}
				break;
			case 2:
				System.out.println("-------[Create Product]---------");
				System.out.print("Product Name: ");
				String name = input.next();
				System.out.print("Product Price: ");
				double price = input.nextDouble();
				Product x = new Product(name, price);
				x.save();
				break;
			case 3:
				System.out.println("-------[Update Product]---------");
				System.out.print("Product Name: ");
				String name1 = input.next();
				System.out.print("Product Price: ");
				double price1 = input.nextDouble();
				product.update(name1, price1);
				break;
			case 4:
				System.out.println("-------[Delete Product]---------");
				System.out.print("Product Name: ");
				String name2 = input.next();
				product.delete(name2);
				break;
			default:
				break;
			}
		} while (mode != 0);
	}

	private static int getModeMain() {
		System.out.println("------------[ Main Menu ] ----------");
		System.out.println("1. Product Mode");
		System.out.println("2. Cart Mode");
		System.out.println("3. Register User");
		System.out.println("0. Exit Main Menu");
		System.out.println("-------------------------------------");
		System.out.print("Select: ");
		int in = input.nextInt();

		return in;
	}

	private static int getModeCart() {
		System.out.println("------------[ Cart Menu ] ----------");
		System.out.println("1. Show Order");
		System.out.println("2. Add Order");
		System.out.println("3. Update Order");
		System.out.println("9. Show Product");
		System.out.println("0. Exit Order Menu");
		System.out.println("-------------------------------------");
		System.out.print("Select: ");
		int in = input.nextInt();

		return in;
	}

	private static int getModeProduct() {
		System.out.println("------------[ Product Menu ] ----------");
		System.out.println("1. Show Product");
		System.out.println("2. Add Product");
		System.out.println("3. Update Product");
		System.out.println("4. Delete Product");
		System.out.println("0. Exit Product Menu");
		System.out.println("-------------------------------------");
		System.out.print("Select: ");
		int in = input.nextInt();

		return in;
	}
}
