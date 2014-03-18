package com.blythe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {

	Product product;

	@Before
	public void setUp() throws Exception {
		product = new Product();
	}

	@Test
	public void testProductName() {
		product.setName("productA");
		assertEquals("productA", product.getName());
	}

	@Test
	public void testGetPriceByProductName() {
		double result = 100.00;
		assertTrue(result == product.getPriceByName("productA"));
	}

	@Test(expected = RuntimeException.class)
	public void testAddProductDuplicate() {
		product = new Product("name", 100.00);
	}

	@Test
	public void testAddProduct() {
		product = new Product("name1", 100.00);
		product.save();
		assertEquals("name1", product.getName());
	}

	@Test
	public void testIsProduct() {
		assertTrue(product.isProduct("name"));
	}
}
