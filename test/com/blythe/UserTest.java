package com.blythe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

	User user;

	@Before
	public void setUp() throws Exception {
		user = new User();
	}

	@Test
	public void testAddUsername() {
		user.setName("user");
		assertEquals("user", user.getName());
	}

}
