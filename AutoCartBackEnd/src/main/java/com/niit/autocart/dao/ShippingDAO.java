package com.niit.autocart.dao;

import java.util.List;

import com.niit.autocart.domain.Shipping;

public interface ShippingDAO {

	public List<Shipping> list(String id);

	public Shipping get(String uname);

	public boolean saveOrUpdate(Shipping shipping);

	public void delete(int sid);

}
