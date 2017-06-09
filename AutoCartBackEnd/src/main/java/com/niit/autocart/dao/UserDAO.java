package com.niit.autocart.dao;

import java.util.List;

import com.niit.autocart.domain.User;

public interface UserDAO {

	public boolean saveOrUpdate(User user);

	public boolean validate(String id, String password);

	public List<User> list();

	public User get(String id);

	public User getemail(String mail);

	public User getname(String name);

	public boolean isAllReadyRegisterMail(String mail, boolean b);
	
	public boolean isAllReadyRegisterContact(String mail, boolean b);
}
