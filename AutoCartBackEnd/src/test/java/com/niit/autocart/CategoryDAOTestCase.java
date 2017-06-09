package com.niit.autocart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.autocart.dao.CategoryDAO;
import com.niit.autocart.domain.Category;



public class CategoryDAOTestCase {
	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static CategoryDAO categoryDAO;
	
	@Autowired  static Category category;
	
	public CategoryDAOTestCase()
	{
		initialize();
		createCategoryDAOTestCase();
	}
	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.autocart");
		context.refresh();
		
		
		categoryDAO =  (CategoryDAO) context.getBean("categoryDAO");
		
	
		
		category = (Category)context.getBean("category");
		
	}
	@Test
	public void createCategoryDAOTestCase() {
	
		category.setCategoryName("bike");
		category.setCategoryDescription("Interiors");
		boolean flag =  categoryDAO.saveorUpdate(category);
		System.out.println(flag);
		
		assertEquals("createCategoryDAOTestCase",true,flag);
	}
	

}
