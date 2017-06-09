package com.niit.autocart.dao;
import java.util.List;

import com.niit.autocart.domain.Category;
public interface CategoryDAO {

	public List<Category> list();
	public Category getById(String id);
	public boolean saveorUpdate(Category category);	
	public void delete(String id);


}
