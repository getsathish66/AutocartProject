package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.autocart.dao.BillingDAO;
import com.niit.autocart.domain.Billing;

@Controller
public class BillingController {

	@Autowired
	private BillingDAO billingDAO;
	
	@RequestMapping("/newBilling")
	public  String newBilling(@ModelAttribute Billing billing, Model model){

		boolean flag = billingDAO.saveOrUpdate(billing);
		model.addAttribute("isUserClickedBilling", "true");
		System.out.println(flag);
		return "home";
		
	}
}
