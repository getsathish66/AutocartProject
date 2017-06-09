package com.niit.autocart.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.autocart.dao.SupplierDAO;
import com.niit.autocart.domain.Supplier;

@Transactional
@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Supplier> list() {
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();

	}

	public Supplier getById(String id) {
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, id);

		
	}

	public boolean saveOrUpdate(Supplier supplier) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}


	@Override
	public void delete(String id) {
		Supplier supplierTodelete = new Supplier();
		supplierTodelete.setId(id);
		sessionFactory.getCurrentSession().delete(supplierTodelete);
		
	}


}
