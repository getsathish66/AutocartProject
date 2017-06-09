package com.niit.autocart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.autocart.dao.BillingDAO;
import com.niit.autocart.domain.Billing;



public class BillingDAOTestCase {
	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static BillingDAO billingDAO;
	
	@Autowired  static Billing billing;
	
	public BillingDAOTestCase()
	{
		initialize();
		createBillingDAOTestCase();
	}
	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.autocart");
		context.refresh();
		
		//get the userDAO from context
		billingDAO =  (BillingDAO) context.getBean("billingDAO");
		
		//get the user from context
		
		billing = (Billing)context.getBean("billing");
		
	}
	@Test
	public void createBillingDAOTestCase() {
	
		billing.setName("Sathish");
		billing.setEmail("sathish@mail.com");
		billing.setContact("9998877766");
		billing.setAddress("vellakoil");
		billing.setCitycode("638111");
		boolean flag =  billingDAO.saveOrUpdate(billing);
		System.out.println(flag);
		
		assertEquals("createBillingDAOTestCase",true,flag);
	}
	

}
