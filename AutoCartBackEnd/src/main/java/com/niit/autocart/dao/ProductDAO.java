package com.niit.autocart.dao;

import java.util.List;

import com.niit.autocart.domain.Product;

public interface ProductDAO {

	public boolean saveorupdate(Product product);

	public List<Product> list();

	public Product get(String id);

	public void delete(String id);

}
