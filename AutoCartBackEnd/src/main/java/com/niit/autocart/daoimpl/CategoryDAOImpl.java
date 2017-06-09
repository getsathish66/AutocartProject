package com.niit.autocart.daoimpl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.autocart.dao.CategoryDAO;
import com.niit.autocart.domain.Category;
@Repository("CategoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Category> list() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	
	}

	public boolean saveorUpdate(Category category) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return false;
	}

	public Category getById(String id) {
		String hql = "from Category where id ='" + id + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) (query).list();

		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}
		return null;
	}

	public void delete(String id) {

		Category categoryToDelete = new Category();
		categoryToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(categoryToDelete);
	}

}
