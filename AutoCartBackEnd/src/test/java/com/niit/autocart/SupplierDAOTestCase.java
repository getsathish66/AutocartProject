package com.niit.autocart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.autocart.dao.SupplierDAO;
import com.niit.autocart.domain.Supplier;



public class SupplierDAOTestCase {
	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static SupplierDAO supplierDAO;
	
	@Autowired  static Supplier supplier;
	
	public SupplierDAOTestCase()
	{
		initialize();
		createSupplierDAOTestCase();
	}
	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.autocart");
		context.refresh();
		
		//get the userDAO from context
		supplierDAO =  (SupplierDAO) context.getBean("supplierDAO");
		
		//get the user from context
		
		supplier = (Supplier)context.getBean("supplier");
		
	}
	@Test
	public void createSupplierDAOTestCase() {
	
		supplier.setSuppliername("Pricol");
		supplier.setSupplierdescription("Spares");
		supplier.setAddress("Coimbatore");
		supplier.setEmail("pricol@mail.com");
		supplier.setContact("9988776655");
		supplier.setCitycode("666666");
		boolean flag =  supplierDAO.saveOrUpdate(supplier);
		System.out.println(flag);
		
		assertEquals("createSupplierDAOTestCase",true,flag);
	}
	

}
