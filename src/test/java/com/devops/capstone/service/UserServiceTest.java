package com.devops.capstone.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.devops.capstone.model.User;

public class UserServiceTest {

	@Test
	public void testIsAutherozied() {
		User u1=new User("Avinash","Patel","1234","avinash.patel@wipro.com");
		assertEquals(true,new UserService().isAuthorized(u1));
	}

	@Test
	public void testUpdatePassword() {
		User u1=new User("","","9876","avinash.patel@wipro.com");
		assertEquals(true,new UserService().updatePassword(u1));
	}

	@Test
	public void testDoRegistration() {
		User u1=new User("RAM","RAJ","1234","raj@wipro.com");
		assertEquals(true,new UserService().doRegistration(u1));
	}

}
