package com.niit.autocart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.autocart.dao.ShippingDAO;
import com.niit.autocart.domain.Shipping;



public class ShippingDAOTestCase {
	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static ShippingDAO shippingDAO;
	
	@Autowired  static Shipping shipping;
	
	public ShippingDAOTestCase()
	{
		initialize();
		createShippingDAOTestCase();
	}
	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.autocart");
		context.refresh();
		
		//get the userDAO from context
		shippingDAO =  (ShippingDAO) context.getBean("shippingDAO");
		
		//get the user from context
		
		shipping = (Shipping)context.getBean("shipping");
		
	}
	@Test
	public void createShippingDAOTestCase() {
	
		shipping.setName("Sathish");
		
		shipping.setContact("9998877766");
		shipping.setAddress("vellakoil");
		
		boolean flag =  shippingDAO.saveOrUpdate(shipping);
		System.out.println(flag);
		
		assertEquals("createShippingDAOTestCase",true,flag);
	}
	

}
