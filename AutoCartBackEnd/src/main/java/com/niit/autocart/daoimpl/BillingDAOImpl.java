package com.niit.autocart.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.autocart.dao.BillingDAO;
import com.niit.autocart.domain.Billing;

@Transactional
@Repository("billingDAO")
public class BillingDAOImpl implements BillingDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public BillingDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Billing> list(String id) {
		return sessionFactory.getCurrentSession().createQuery("from Billing").list();

	}

	public Billing get(String uname) {
		return (Billing) sessionFactory.getCurrentSession().get(Billing.class, uname);

		
	}

	public boolean saveOrUpdate(Billing billing) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(billing);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}


	@Override
	public void delete(String bid) {
		Billing billingTodelete = new Billing();
		billingTodelete.setBid(bid);
		sessionFactory.getCurrentSession().delete(billingTodelete);
		
	}


}
