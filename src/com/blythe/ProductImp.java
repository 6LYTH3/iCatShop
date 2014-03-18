package com.blythe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ProductImp implements ProductService {
	public static String newline = System.getProperty("line.separator");
	private FileWriter fw;
	private FileReader fr;
	private BufferedReader br;

	@Override
	public ArrayList<String> getOrderByName(String name) {
		String buff;
		ArrayList<String> order = new ArrayList<String>();
		try {
			fr = new FileReader("cart.txt");
			br = new BufferedReader(fr);
			while ((buff = br.readLine()) != null) {
				String[] username = buff.split(":");
				if (username[0].equals(name)) {
					order.add(buff);
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (order.isEmpty()) ? null : order;
	}

	@Override
	public void addCart(String username, String product, double price,
			int items, String status) {
		try {
			fw = new FileWriter("cart.txt", true);
			fw.write(username + ":" + product + ":" + price + ":" + items + ":"
					+ status + newline);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Created");

	}

	@Override
	public void updateCart(String name, String product, double price,
			int items, String status) {
		String buff;
		ArrayList<String> backup = new ArrayList<String>();
		try {
			fr = new FileReader("cart.txt");
			br = new BufferedReader(fr);
			while ((buff = br.readLine()) != null) {
				String[] order = buff.split(":");
				if (!(order[0].equals(name) && order[1].equals(product)
						&& Integer.valueOf(order[3]) == items || order[4] == "Offer")) {
					backup.add(buff);
				}
			}
			br.close();

			File file = new File("cart.txt");
			file.delete();

			fw = new FileWriter("cart.txt", true);
			for (String data : backup) {
				fw.write(data + newline);
			}
			fw.write(name + ":" + product + ":" + price + ":" + items + ":"
					+ status + newline);
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Updated");

	}

	@Override
	public String getProductByName(String name) {
		String buff;
		try {
			fr = new FileReader("product.txt");
			br = new BufferedReader(fr);
			while ((buff = br.readLine()) != null) {
				String[] product = buff.split(":");
				if (product[0].equals(name)) {
					return name;
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Double getPriceByProduct(String name) {
		String buff;
		try {
			fr = new FileReader("product.txt");
			br = new BufferedReader(fr);
			while ((buff = br.readLine()) != null) {
				String[] price = buff.split(":");
				if (price[0].equals(name)) {
					return Double.valueOf(price[1]);
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0.00;
	}

	@Override
	public void addProduct(String name, double price) {
		try {
			fw = new FileWriter("product.txt", true);
			fw.write(name + ":" + price + newline);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Created");
	}

	@Override
	public void updateProduct(String name, double price) {

	}

	@Override
	public void delectProudct(String name) {

	}

}
