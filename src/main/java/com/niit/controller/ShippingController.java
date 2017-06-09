package com.niit.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.autocart.dao.MycartDAO;
import com.niit.autocart.dao.ShippingDAO;
import com.niit.autocart.dao.UserDAO;
import com.niit.autocart.domain.Mycart;
import com.niit.autocart.domain.Shipping;
import com.niit.autocart.domain.User;
@Controller
public class ShippingController {
	
	
	@Autowired
	private ShippingDAO shippingDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private MycartDAO mycartDAO;
	
	@Autowired
	private Mycart mycart;
	
	
	@RequestMapping("shippingaddPage")
	public ModelAndView newShippingaddress(){
		
		ModelAndView mv = new ModelAndView("userLogin");
		mv.addObject("newShippingaddressClicked", "true");
		return mv;
}
	
	
	@RequestMapping("newaddress")
	public String newaddress(Principal p, @ModelAttribute Shipping shipping   ){
		User user = userDAO.getemail(p.getName());

		shipping.setMail(p.getName());
		
		shippingDAO.saveOrUpdate(shipping);
		return "redirect:proceed";
		
	}
	
	
	@RequestMapping("proceed")
	public String Proceed(Principal p, Model model){
		String mail = 	p.getName();
		List<Shipping> shippingList = shippingDAO.list(mail);
		model.addAttribute("shippingList", shippingList);
		model.addAttribute("isUserClickedShippingAddress", true);
	 return "userLogin";
	}
	
	
	@RequestMapping("deleteshippingAddress")
	public String deleteshippingAddress(@RequestParam("shippingId") int shippingId, Model model){
		shippingDAO.delete(shippingId);
		return "redirect:proceed";
		
	}
	
	
	@RequestMapping("shippingAddress")
	public String shippingAddress(@RequestParam("shippingId") int shippingId, Principal p, Model model){
		
		String mail = p.getName();
		List<Mycart> mycartList = mycartDAO.getByMail(mail);
		
		for(Mycart c : mycartList){
			c.setSid(shippingId);
			mycartDAO.saveOrUpdate(c);
		}
		model.addAttribute("deliverhereClicked", true);
		/*model.addAttribute("thankyouPage", true);*/
		return "userLogin";
		
	}
	
	@RequestMapping("ThankyouPage")
	public String ThankyouPage( Model model){
		model.addAttribute("checkoutClicked", true);
		return "userLogin";
	}
	
	
	@ModelAttribute
	public void commonToUser(Model model){
		model.addAttribute("isUser", "true");
	}
	

}
