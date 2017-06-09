package com.niit.autocart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.autocart.dao.MycartDAO;
import com.niit.autocart.domain.Mycart;



public class MycartDAOTestCase {
	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static MycartDAO mycartDAO;
	
	@Autowired  static Mycart mycart;
	
	public MycartDAOTestCase()
	{
		initialize();
		createMycartDAOTestCase();
	}
	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.autocart");
		context.refresh();
		
		//get the userDAO from context
		mycartDAO =  (MycartDAO) context.getBean("mycartDAO");
		
		//get the user from context
		
		mycart = (Mycart)context.getBean("mycart");
		
	}
	@Test
	public void createMycartDAOTestCase() {
	
/*		mycart.setName("Jenu");
		mycart.setQuantity("1");
		mycart.setPrice("365");
		mycart.setDate("02/02/17");
		mycart.setTotal("365");*/
		 mycartDAO.saveOrUpdate(mycart);
		
	}
	

}
