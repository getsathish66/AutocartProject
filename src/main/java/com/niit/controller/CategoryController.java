package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.autocart.dao.CategoryDAO;
import com.niit.autocart.domain.Category;

@Controller
public class CategoryController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping("/newCategory")
	public  String newCategory(@ModelAttribute Category category, Model model){

		boolean flag = categoryDAO.saveorUpdate(category);
		model.addAttribute("isUserClickedCategory", "true");
		System.out.println(flag);
		return "redirect:/ViewCategoryPage";
		
	}
	@RequestMapping("/Categoriespage")
	public String categoryPage(Model model)
	{
		model.addAttribute("isAdmin", "true");
		model.addAttribute("isAdminClickedCategory", "true");
		return "adminLogin";
	}
	
	@RequestMapping("/ViewCategoryPage")
	public String ViewCategoryPage(Model model)
	{
		model.addAttribute("isAdmin", "true");
		List<Category> categoryList = categoryDAO.list();
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("isAdminClickedViewCategory", "true");
		return "adminLogin";
	}
	@RequestMapping("/editCategory")
	public String EditCategoryPage(@RequestParam(value = "categoryId") String id, Model model) {
		model.addAttribute("isAdmin", "true");
		Category category = categoryDAO.getById(id);
		model.addAttribute("category", category);
		model.addAttribute("isAdminClickedEditCategory", "true");
		return "adminLogin";

	}
	@RequestMapping("deleteCategory")
	public String deleteCategory(@RequestParam(value = "categoryId") String id) {

		categoryDAO.delete(id);
		return "redirect:/ViewCategoryPage";
	}
	
	@RequestMapping("/EditCategoryPage")
	public String EditCategoryPage(Model model)
	{
		model.addAttribute("isAdmin", "true");

		model.addAttribute("isAdminClickedEditCategoryt", "true");
		return "adminLogin";
	
	
	}
/*	@RequestMapping("/editCategory")
	public String EditCategoryPage(@RequestParam(value = "categoryId") String id, Model model) {
		model.addAttribute("isAdmin", "true");
		Category category = categoryDAO.getById(id);
		model.addAttribute("category", category);
		model.addAttribute("isAdminClickedEditcategory", "true");
		return "adminLogin";

	}*/

	@RequestMapping("afterEditCategory")
	public String afterEditCategory(@ModelAttribute Category category, Model model) {
		boolean flag = categoryDAO.saveorUpdate(category);
		System.out.println(flag);
		
		return "redirect:/ViewCategoryPage";

	}
	@ModelAttribute
	public void adminCategory (Model model){
	model.addAttribute("isAdmin", "true");
	}
	
}
