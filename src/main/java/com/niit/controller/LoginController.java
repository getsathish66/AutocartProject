package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.autocart.dao.RoleDAO;
import com.niit.autocart.dao.UserDAO;
import com.niit.autocart.domain.Role;


@Controller

public class LoginController {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private RoleDAO roleDAO;

	@Autowired
	private Role role;

	@RequestMapping("signIn")
	public String showMessage(@RequestParam(value = "mail") String mail,
			@RequestParam(value = "password") String password, Model model) {
		System.out.println("in controller");
		// String message;
		String message;
		if (userDAO.validate(mail, password)) {

			role = roleDAO.getByMailId(mail);
			String u = "ROLE_USER";
			//String admin = "ROLE_ADMIN";
			String r = role.getRole();
			System.out.println(r);

			if (r.equals(u)) {
				message = "userLogin";
				model.addAttribute("isUser", "true");
			} 
			else {
				message = "adminLogin";
				model.addAttribute("isAdmin", "true");
			}
			model.addAttribute("message", "Valid Credentials");
			model.addAttribute("email", mail);
			return message;
		} else {

			model.addAttribute("message", "Invalid Credentials");
			message = "home";
			
		}
		return message;
	}
}