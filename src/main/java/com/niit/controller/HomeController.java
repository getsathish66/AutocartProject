package com.niit.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.autocart.dao.CategoryDAO;
import com.niit.autocart.dao.ProductDAO;
import com.niit.autocart.dao.SupplierDAO;
import com.niit.autocart.domain.Category;
import com.niit.autocart.domain.Product;
import com.niit.autocart.domain.Supplier;

@Controller

public class HomeController {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping("/")
	public String goTohome(Model model) {
		List<Product> ProductList = productDAO.list();

		List<Supplier> supplierList = supplierDAO.list();

		List<Category> categoryList = categoryDAO.list();

		model.addAttribute("ProductList", ProductList);
		model.addAttribute("supplierList", supplierList);
		model.addAttribute("categoryList", categoryList);

		model.addAttribute("message", "Experience the world class quality");
		return "home";
	}

	@RequestMapping("/LoginPage")
	public String loginPage(Model model) {
		model.addAttribute("isUserClickedLogin", "true");

		return "home";
	}

	@RequestMapping("/RegisterPage")
	public String RegisterPage(Model model) {
		model.addAttribute("isUserClickedRegister", "true");

		return "home";
	}

	@RequestMapping("/Homepage")
	public String HomePage(Model model) {
		model.addAttribute("isUserClickedHome", "true");

		return "home";
	}

	@RequestMapping("/Carspage")
	public String CarsPage(Model model) {
		model.addAttribute("isUserClickedCars", "true");

		return "home";
	}

	@RequestMapping("/Bikespage")
	public String Bikespage(Model model) {
		model.addAttribute("isUserClickedBikes", "true");

		return "home";
	}

	@RequestMapping("/Truckspage")
	public String Truckspage(Model model) {
		model.addAttribute("isUserClickedTrucks", "true");

		return "home";
	}

	/*
	 * @RequestMapping("/Productspage") public String Productspage(Model model)
	 * { model.addAttribute("isUserClickedProduct", "true");
	 * 
	 * return "product"; }
	 */
	/*
	 * @RequestMapping("/Supplierspage") public String Supplierspage(Model
	 * model) { model.addAttribute("isUserClickedSupplier", "true");
	 * 
	 * return "supplier"; }
	 * 
	 * @RequestMapping("/Categoriespage") public String Categoriespage(Model
	 * model) { model.addAttribute("isUserClickedCategory", "true");
	 * 
	 * return "category"; }
	 */

	@RequestMapping("/Billingpage")
	public String Billingpage(Model model) {
		model.addAttribute("isUserClickedBilling", "true");

		return "billing";
	}

}
