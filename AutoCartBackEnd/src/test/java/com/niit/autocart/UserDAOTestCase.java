package com.niit.autocart;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.autocart.dao.UserDAO;
import com.niit.autocart.domain.User;

public class UserDAOTestCase {

	
	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static UserDAO userDAO;
	
	@Autowired  static User user;
	
	public UserDAOTestCase()
	{
		initialize();
		createUserDAOTestCase();
	}
	
	//The above objects need to initialize
	/**
	 * This method is going execute before calling any one of test case
	 * and will execute only once
	 */
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.autocart");
		context.refresh();
		
		//get the userDAO from context
		userDAO =  (UserDAO) context.getBean("userDAO");
		
		//get the user from context
		
		user = (User)context.getBean("user");
		
	}
	
	@Test
	public void createUserDAOTestCase()
	{
		user.setId("1");
		user.setName("Suveen Kumar");
		user.setPassword("suveen");
		user.setMail("get@gmail");
		user.setUsername("sathish66");
		user.setContact("DilshukNagar");
		
		boolean flag =  userDAO.saveOrUpdate(user);
		
		System.out.println(flag);
		
		//assertEquals("createUserDAOTestCase",true,flag);
		
	}
	
	
	
	
}











