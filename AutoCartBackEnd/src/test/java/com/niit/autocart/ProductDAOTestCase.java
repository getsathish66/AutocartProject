package com.niit.autocart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.autocart.dao.ProductDAO;
import com.niit.autocart.domain.Product;



public class ProductDAOTestCase {
	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static ProductDAO productDAO;
	
	@Autowired  static Product product;
	
	public ProductDAOTestCase()
	{
		initialize();
		createProductDAOTestCase();
	}
	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.autocart");
		context.refresh();
		
		//get the userDAO from context
		productDAO =  (ProductDAO) context.getBean("productDAO");
		
		//get the user from context
		
		product = (Product)context.getBean("product");
		
	}
	@Test
	public void createProductDAOTestCase() {
	
		product.setProductName("Seat cover");
		/*product.setProductPrize("1000");*/
		product.setProductDescription("Good quality");
		product.setProductQuantity(10);
		boolean flag =  productDAO.saveorupdate(product);
		System.out.println(flag);
		
		assertEquals("createProductDAOTestCase",true,flag);
	}
	

}
