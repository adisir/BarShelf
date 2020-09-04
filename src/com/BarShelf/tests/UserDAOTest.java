package com.BarShelf.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.BarShelf.services.UserService;

public class UserDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void checkUserExists() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.scan("com.BarShelf");
		appContext.refresh();
		UserService us = (UserService) appContext.getBean("userService");
		assertTrue(us.checkUserExists("jim.gordon@gmail.com"));
	}
	@Test
	public void findUser() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.scan("com.BarShelf");
		appContext.refresh();
		UserService us = (UserService) appContext.getBean("userService");
		assertTrue(us.findUser("jim.gordon@gmail.com", "gothampd" )!=null);
	}
	@Test
	public void findUser2() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.scan("com.BarShelf");
		appContext.refresh();
		UserService us = (UserService) appContext.getBean("userService");
		assertTrue(us.findUser("jim.gordon@gmail.com", "gotham" )==null);
	}

}
