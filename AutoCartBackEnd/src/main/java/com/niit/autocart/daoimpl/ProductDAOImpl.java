package com.niit.autocart.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.autocart.dao.ProductDAO;
import com.niit.autocart.domain.Product;

@Repository("ProductDAO")
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveorupdate(Product product) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
		} catch (Exception e) {
			// if any excpetion comes during execute of try block, catch will
			// excute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Product> list() {

		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	@Transactional
	public Product get(String id) {

		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);

	}

	@Transactional
	public void delete(String id) {
		Product productToDelete = new Product();
	   	productToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(productToDelete);
		
	}

}
