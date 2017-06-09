package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.autocart.dao.SupplierDAO;
import com.niit.autocart.domain.Product;
import com.niit.autocart.domain.Supplier;

@Controller
public class SupplierController {

	@Autowired
	private SupplierDAO supplierDAO;
	
	@RequestMapping("/newSupplier")
	public  String newSupplier(@ModelAttribute Supplier supplier, Model model){

		boolean flag = supplierDAO.saveOrUpdate(supplier);
		model.addAttribute("isUserClickedSupplier", "true");
		System.out.println(flag);
		return "redirect:/ViewSupplierPage";
		
	}
	@RequestMapping("/Supplierspage")
	public String supplierPage(Model model)
	{
		model.addAttribute("isAdmin", "true");
		model.addAttribute("isAdminClickedSupplier", "true");
		return "adminLogin";
	}
	
	@RequestMapping("/ViewSupplierPage")
	public String ViewSupplierPage(Model model)
	{
		model.addAttribute("isAdmin", "true");
		List<Supplier> supplierList = supplierDAO.list();
		model.addAttribute("supplierList", supplierList);
		model.addAttribute("isAdminClickedViewSupplier", "true");
		return "adminLogin";
	}
	@RequestMapping("deleteSupplier")
	public String deleteSupplier(@RequestParam(value = "supplierId") String id) {

		supplierDAO.delete(id);
		return "redirect:/ViewSupplierPage";
	}
	
	@RequestMapping("/editSupplier")
	public String EditSupplierPage(@RequestParam(value = "supplierId") String id, Model model) {
		model.addAttribute("isAdmin", "true");
		Supplier supplier = supplierDAO.getById(id);
		model.addAttribute("supplier", supplier);
		model.addAttribute("isAdminClickedEditSupplier", "true");
		return "adminLogin";

	}

	@RequestMapping("afterEditSupplier")
	public String afterEditSupplier(@ModelAttribute Supplier supplier, Model model) {
		boolean flag = supplierDAO.saveOrUpdate(supplier);
		System.out.println(flag);
		
		return "redirect:/ViewSupplierPage";

	}
/*	@RequestMapping("/EditSupplierPage")
	public String EditSupplierPage(Model model)
	{
		model.addAttribute("isAdmin", "true");

		model.addAttribute("isAdminClickedEditSupplier", "true");
		return "adminLogin";
	
	
	}*/
	@ModelAttribute
	public void adminProduct (Model model){
	model.addAttribute("isAdmin", "true");
	}
}
