package com.niit.autocart.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.autocart.dao.UserDAO;
import com.niit.autocart.domain.User;

@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;


	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Transactional
	public boolean saveOrUpdate(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
		return true;
	}

	

		@Transactional
	public boolean validate(String mail, String password) {

			String hql = "from User where mail= '" + mail + "' and " + " password ='" + password+"'";
			org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<User> list = (List<User>) query.list();
			if (list != null && !list.isEmpty()) {
				return true;
			}
			return false;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> list() {

		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Transactional
	public User get(String mail) {

	
		return (User) sessionFactory.getCurrentSession().get(User.class, mail);

	}



	@Transactional
	public User getemail(String mail) {
		
		String hql = "from User where mail ='"+ mail +"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) query.list();
		
		if (listUser != null && !listUser.isEmpty()){
			return listUser.get(0);
		}
		return null;
		
	}
	
	
	@Transactional
	public User getname(String name) {
		
		String hql = "from User where name ='"+ name +"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) query.list();
		
		if (listUser != null && !listUser.isEmpty()){
			return listUser.get(0);
		}
		return null;
		
	}


	@Transactional
	public boolean isAllReadyRegisterMail(String mail, boolean b) {
		String hql = "from User where mail ='"+ mail +"'";
		
		
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		if (list != null && !list.isEmpty()) {
			return true;
		}
		return false;
	}


	@Transactional
	public boolean isAllReadyRegisterContact(String contact, boolean b) {
		String hql = "from User where contact ='"+ contact +"'";
		
		
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		if (list != null && !list.isEmpty()) {
			return true;
		}
		return false;
	}
	

}
