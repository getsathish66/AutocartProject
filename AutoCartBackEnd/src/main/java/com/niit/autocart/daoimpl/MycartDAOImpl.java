package com.niit.autocart.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.autocart.dao.MycartDAO;
import com.niit.autocart.domain.Mycart;
import com.niit.autocart.domain.User;

@Transactional
@Repository("mycartDAO")
public class MycartDAOImpl implements MycartDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public MycartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Mycart> list(int cartid) {
		return sessionFactory.getCurrentSession().createQuery("from Mycart").list();

	}
 
	public Mycart getById(int cartid) {
		return (Mycart) sessionFactory.getCurrentSession().get(Mycart.class, cartid);

		
	}
	
	public List<Mycart> getByMail(String mail) {
		String hql = "from Mycart where mail= '" +mail+"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Mycart> list = (List<Mycart>) query.list();
		
		return list;
	}
	
	public List<Mycart> getByid(String id) {
		String hql = "from Product where id= '" +"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Mycart> list = (List<Mycart>) query.list();
		
		return list;
	}

	

	public void saveOrUpdate(Mycart mycart) {
	
		sessionFactory.getCurrentSession().saveOrUpdate(mycart);
		}


	public void delete(int cartid) {
		Mycart mycartTodelete = new Mycart();
		mycartTodelete.setCartid(cartid);
		sessionFactory.getCurrentSession().delete(mycartTodelete);
		
	}



	@Override
	public boolean validate(String cartid, String password) {
		Query query=sessionFactory.getCurrentSession().createQuery(" from Mycart where cartid = ? and password = ?");
		query.setString(1, cartid);     
		query.setString(2, password);
		 if(  query.uniqueResult()  == null)
		 {
			 
			 return false;
		 }
		 else
		 {
			 
			 return true;
		 }
		
		}

	@Override
	public List<Mycart> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getTotal(String id) {
		String hql = "select sum(total) from Mycart where mail = " + "'" + id + "'" + "and status = '" + "N" +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Long sum = (Long) query.uniqueResult();
			return sum;
	}

	@Override
	public Mycart getByUserandProduct(String mail, String productId) {
		
		String hql = "from Mycart where mail= '" + mail + "' and " + " productId ='" + productId +"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Mycart> listMycart = (List<Mycart>) query.list();
		
		if (listMycart != null && !listMycart.isEmpty()){
			return listMycart.get(0);
		}
		return null;
	}

	public boolean itemAlreadyExist(String mail, String productId, boolean b){
		
		String hql = "from Mycart where mail= '" + mail + "' and " + " productId ='" + productId+"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Mycart> list = (List<Mycart>) query.list();
		if (list != null && !list.isEmpty()) {
			return true;
		}
		return false;
	}

	

	
	
}
