package com.niit.autocart.dao;

import java.util.List;

import com.niit.autocart.domain.Mycart;

public interface MycartDAO {
	public Mycart getById(int cartid);
	
	public List<Mycart> getByMail(String mail);
	
	public List<Mycart> list();
	
	public boolean validate(String cartid, String password);
	
	public void delete(int cartid);
	
	public void saveOrUpdate(Mycart mycart);
	
	public Long getTotal(String id);
	
	public Mycart getByUserandProduct(String email, String productId);

	public boolean itemAlreadyExist(String mail, String productId, boolean b);
	


}
