package com.niit.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.autocart.dao.ProductDAO;
import com.niit.autocart.dao.RoleDAO;
import com.niit.autocart.dao.ShippingDAO;
import com.niit.autocart.dao.UserDAO;
import com.niit.autocart.domain.Product;
import com.niit.autocart.domain.Role;
import com.niit.autocart.domain.Shipping;
import com.niit.autocart.domain.User;

@SuppressWarnings("unused")
@Controller
@Transactional

public class UserController {

	@Autowired
	private ProductDAO productDAO;

	
	@Autowired
	private RoleDAO roleDAO;

	@Autowired
	private Role role;

	@Autowired
	private UserDAO userDAO;
	
	@Autowired 
	private ShippingDAO shippingDAO;
	
	@RequestMapping("newUser")
	public String newUser(@ModelAttribute User user, @ModelAttribute Shipping shipping, Model model){
		
		String message;
		
		if(userDAO.isAllReadyRegisterMail(user.getMail(), true) && userDAO.isAllReadyRegisterContact(user.getContact(), true)){
			
			message = "Your EmailId and Contact All Ready Registered";
			
		} else if (userDAO.isAllReadyRegisterMail(user.getMail(), true)) {
			message = "Your Email Id All Ready Registered";
		}else if (userDAO.isAllReadyRegisterContact(user.getContact(), true)) {
			message = "Your Contact Number All Ready Registered";
		}
		else{
		
		role.setRole("ROLE_USER");
		role.setName(user.getName());
		role.setMail(user.getMail());
		user.setEnabled(true);
		
		user.setRole(role);
		role.setUser(user);
		
		
		userDAO.saveOrUpdate(user);
		roleDAO.saveOrUpdate(role);
		
		shipping.setMail(user.getMail());
		shippingDAO.saveOrUpdate(shipping);
		message = "Your Have Successfully Registered";
		}
		model.addAttribute("message", message);
		model.addAttribute("isUserClickedLogin", "true");
		return "home";
		
	}
	@RequestMapping("afterLogin")
	public String loginValidate(Principal p,Model model)
	{
		String email=p.getName();
		User user=userDAO.getemail(email);
		Role role=roleDAO.getByMailId(email);
		String approve=role.getRole();
		if(approve.equals("ROLE_ADMIN")){
			model.addAttribute("isAdmin",true);
			return "adminLogin";
		}
		else if(approve.equals("ROLE_USER")){

			List<Product> ProductList = productDAO.list();
			model.addAttribute("ProductList", ProductList);
			
			model.addAttribute("isUser",true);

			return "userLogin";
		}
		else{
			return "login";
		}
		
	}
	

	
}