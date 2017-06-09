package com.niit.autocart.dao;

import java.util.List;

import com.niit.autocart.domain.Supplier;

public interface SupplierDAO {

	public List<Supplier> list();

	public Supplier getById(String id);

	public boolean saveOrUpdate(Supplier supplier);

	public void delete(String id);

}
