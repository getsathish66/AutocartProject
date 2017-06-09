package com.niit.autocart.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.autocart.dao.ShippingDAO;
import com.niit.autocart.domain.Shipping;

@Transactional
@Repository("shippingDAO")
public class ShippingDAOImpl implements ShippingDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ShippingDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Shipping> list(String id) {
		return sessionFactory.getCurrentSession().createQuery("from Shipping").list();

	}

	public Shipping get(String uname) {
		return (Shipping) sessionFactory.getCurrentSession().get(Shipping.class, uname);

		
	}

	public boolean saveOrUpdate(Shipping shipping) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(shipping);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}


	public void delete(int sid) {
		Shipping shippingToDelete = new Shipping();
		shippingToDelete.setSid(sid);
		sessionFactory.getCurrentSession().delete(shippingToDelete);

		
	}


}
