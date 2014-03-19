package com.blythe;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int mode = -1;
		Product product = new Product();
		do {
			mode = getMode();
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
		System.out.println("Good Bye");
	}

	private static int getMode() {
		System.out.println("------------[ Product Menu ] ----------");
		System.out.println("1. Show Product");
		System.out.println("2. Add Product");
		System.out.println("3. Update Product");
		System.out.println("4. Delete Product");
		System.out.println("0. Exit");
		System.out.println("-------------------------------------");
		System.out.print("Select: ");
		int in = input.nextInt();

		return in;
	}
}
