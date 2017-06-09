package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.autocart.dao.CategoryDAO;
import com.niit.autocart.dao.ProductDAO;
import com.niit.autocart.dao.SupplierDAO;
import com.niit.autocart.domain.Category;
import com.niit.autocart.domain.Product;
import com.niit.autocart.domain.Supplier;
import com.niit.util.FileUtil;

@Controller

public class ProductController {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired(required = true)
	private CategoryDAO categoryDAO;
	
	@Autowired(required = true)
	private SupplierDAO supplierDAO;

	@RequestMapping("/newProduct")
	public String newProduct(@ModelAttribute Product product, @RequestParam("image") MultipartFile file, Model model) {
		
		String path = "E://NIIT/workspace2/AutoCart/src/main/webapp/WEB-INF/resources/images/product/";
		
		//productDAO.saveorupdate(product);
		
				boolean flag = productDAO.saveorupdate(product);
				
				FileUtil.upload(path, file, product.getId()+ ".jpg");
				
				

		model.addAttribute("isUserClickedProduct", "true");
		System.out.println(flag);
		return "redirect:/ViewProductPage";

	}

	@RequestMapping("/Productspage")
	public String productPage(Model model) {
		
		List<Category> categoryList = categoryDAO.list();
		model.addAttribute("categoryList", categoryList);
		
		List<Supplier> supplierList = supplierDAO.list();
		model.addAttribute("supplierList", supplierList);
		
		/*model.addAttribute("isAdmin", "true");*/
		model.addAttribute("isAdminClickedProduct", "true");
		return "adminLogin";
	}

	@RequestMapping("/ViewProductPage")
	public String ViewProductPage(Model model) {
		model.addAttribute("isAdmin", "true");
		List<Product> productList = productDAO.list();
		model.addAttribute("productList", productList);
		model.addAttribute("isAdminClickedViewProduct", "true");
		return "adminLogin";
	}

	@RequestMapping("deleteProduct")
	public String deleteProduct(@RequestParam(value = "id") String id) {

		productDAO.delete(id);
		return "redirect:/ViewProductPage";
	}

	@RequestMapping("/editProduct")
	public String EditProductPage(@RequestParam(value = "id") String id, Model model) {
		model.addAttribute("isAdmin", "true");
		Product product = productDAO.get(id);
		model.addAttribute("product", product);
		model.addAttribute("isAdminClickedEditProduct", "true");
		return "adminLogin";

	}

	@RequestMapping("afterEditProduct")
	public String afterEditProduct(@ModelAttribute Product product, Model model) {
		boolean flag = productDAO.saveorupdate(product);
		System.out.println(flag);
		
		return "redirect:/ViewProductPage";

	}
	



	@ModelAttribute
	public void adminProduct(Model model) {
		model.addAttribute("isAdmin", "true");
	}


	
}
