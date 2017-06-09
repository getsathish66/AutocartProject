package com.niit.autocart.dao;

import java.util.List;

import com.niit.autocart.domain.Billing;

public interface BillingDAO {

	public List<Billing> list(String id);

	public Billing get(String uname);

	public boolean saveOrUpdate(Billing billing);

	public void delete(String bid);

}
