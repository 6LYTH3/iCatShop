package com.blythe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RegisterTest {

	Register register;

	@Before
	public void setUp() throws Exception {
		register = new Register();
	}

	@Test
	public void testCheckValideUser() {
		assertFalse(register.isUser("name"));
	}

	@Test
	public void testAddUsernameDuplicateShouldFail() {
		assertFalse(register.addUser("username", null));
	}

	@Test
	public void testAddUsername() {
		assertTrue(register.addUser("name", null));
		assertEquals("name", register.getName());
	}
}
