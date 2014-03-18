package com.blythe;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int mode = -1;
		do {
			mode = getMode();
			switch (mode) {
			case 0:
				break;
			case 1:
				Product product = new Product();
				ArrayList<String> productList = product.show();
				for (String pl : productList) {
					String[] p = pl.split(":");
					System.out.println(p[0] + " | " + p[1]);
				}
			case 2:
				break;
			case 3:
				break;
			default:
			}
		} while (mode == 0);
		System.out.println("Good Bye");
	}

	private static int getMode() {
		System.out.println("------------Menu----------");
		System.out.println("1. Show Product");
		System.out.println("2. Add Cart");
		System.out.println("3. Update Cart");
		System.out.println("0. Exit");
		System.out.print("Select: ");
		int in = input.nextInt();

		return in;
	}

}
