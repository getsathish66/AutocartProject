package com.niit.autocart.dao;

import java.util.List;

import com.niit.autocart.domain.Role;

public interface RoleDAO {
	
	public List<Role> list();
	
	public Role getByName(String username);
	
	public Role getByMailId(String Mailid);

	public void delete(String username);

	public void saveOrUpdate(Role role);

}

