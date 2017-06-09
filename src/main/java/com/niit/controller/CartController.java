package com.niit.controller;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.autocart.dao.MycartDAO;
import com.niit.autocart.dao.ProductDAO;
import com.niit.autocart.dao.UserDAO;
import com.niit.autocart.domain.Mycart;
import com.niit.autocart.domain.Product;
import com.niit.autocart.domain.User;
@Controller

public class CartController {
	@Autowired
	private ProductDAO productDAO;
	@Autowired 
	private MycartDAO  mycartDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private Mycart mycart;
	
	@RequestMapping("productdetails")
	public String productdescription(@RequestParam("id") String id, Model model)
	{
		model.addAttribute("isUser", true);
		List<Product> productList = productDAO.list();
		model.addAttribute("productList", productList);
		Product product = productDAO.get(id);
		model.addAttribute("product", product);
		model.addAttribute("productdetails", "true");
		
		
		return "userLogin";
		
	}
/*	@RequestMapping("mycart")
	public String mycart(@RequestParam("id") String id, Principal p, Model model){
		Product product = productDAO.get(id);
		User user = userDAO.getemail(p.getName());
		Mycart mycart = mycartDAO.getByUserandProduct(p.getName(), id);
		mycart.setEmail(p.getName());
		mycart.setPrice(product.getProductPrize());
		mycart.setName(product.getProductName());
		mycart.setQuantity(1);
		mycart.setStatus("N");
		mycart.setUsername(user.getUsername());
		mycart.setTotal(product.getProductPrize());
		
		Long currentTime=System.currentTimeMillis();
		Date currentDate=new Date(currentTime);
		mycart.setDate(currentDate);
		
		mycartDAO.saveOrUpdate(mycart);
		model.addAttribute("isUserClickedadd to cart", true);
		
		
		return "mycart";
		
}*/

	
@RequestMapping("mycart")
public String mycart(Principal p, Model model){
	String mail=p.getName();
	User user=userDAO.getemail(mail);
	
	List<Mycart> mycartList = mycartDAO.getByMail(mail);
	Long total=mycartDAO.getTotal(user.getMail());
	model.addAttribute("total",total);
	model.addAttribute("mycartList",mycartList);
	model.addAttribute("isUserClickedaddtocart", "true");
	return "userLogin";
}

@RequestMapping("addtocart")
public String addtocart(@RequestParam("productId") String productId , Principal p, Model model){

	Product product = productDAO.get(productId);
	String mail=p.getName();
     User user=userDAO.getemail(mail);
		model.addAttribute("isUser", "true");
		List<Mycart> mycartList = mycartDAO.getByMail(mail);
		model.addAttribute("mycartList", mycartList);
		model.addAttribute("isUserClickedaddtocart", "true");
		Mycart mycrt = mycartDAO.getByUserandProduct(p.getName(), productId);

		
		if (product.getProductQuantity() > 0) {

			if (mycartDAO.itemAlreadyExist(p.getName(), productId, true)) {
				
				int qty = mycrt.getQuantity() + 1;
				mycrt.setQuantity(qty);
				mycrt.setTotal(product.getProductPrize() * qty);
				 mycartDAO.saveOrUpdate(mycrt);
				
				System.out.println(qty);
			} 
			else {
				Random t = new Random();
				int day = 2 + t.nextInt(7);
		
	
	mycart.setProductId(product.getId());
	mycart.setProductName(product.getProductName());
	mycart.setMail(p.getName());
	mycart.setQuantity(1);
	mycart.setPrice(product.getProductPrize());
	mycart.setStatus("N");
	mycart.setTotal(product.getProductPrize() * mycart.getQuantity());
	mycart.setDays(day);
	Long currentTime = System.currentTimeMillis();
	Date currentDate = new Date(currentTime);
	mycart.setDate(currentDate);
	
	mycartDAO.saveOrUpdate(mycart);
			}
			int stc = product.getProductQuantity() - 1;
			product.setProductQuantity(stc);

			productDAO.saveorupdate(product);
			return "redirect:mycart";
		}
		else {
			model.addAttribute("product", product);

			model.addAttribute("productDetails", true);
		
			model.addAttribute("message", "Out of stock");
		
	return "userLogin";
		}
}
			
@RequestMapping("removecart")
public String removecart(@RequestParam("cartid") int cartid, Model model) {
	
	Mycart mycart = mycartDAO.getById(cartid);
	Product product = productDAO.get(mycart.getProductId());
	
	int qty = product.getProductQuantity() + mycart.getQuantity();
	
	product.setProductQuantity(qty);
	productDAO.saveorupdate(product);
	
	mycartDAO.delete(cartid);
	return "redirect:mycart";
}
@ModelAttribute
public void commonToUser(Model model){
	model.addAttribute("isUser", "true");
}

}
