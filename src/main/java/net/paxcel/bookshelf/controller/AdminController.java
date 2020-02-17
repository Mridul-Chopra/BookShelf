package net.paxcel.bookshelf.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import net.paxcel.bookshelf.service.GetAdminInfoService;

@Controller
public class AdminController {
	
	@Autowired
	Logger log;
	
	@Autowired
	GetAdminInfoService books; // service layer interface
	
	
	
	@RequestMapping(value="/admin" , method=RequestMethod.GET)
	public String admin( )
	{
	
		return "admin";

	}
	
	
	@RequestMapping(value="/all" , method=RequestMethod.GET)
	public String displayAll(  Model model  )
	{
	
		List<?> booksList = books.getBooks(1);	  // getting all books in db
		model.addAttribute("booksList" , booksList); // adding books to model
		model.addAttribute("option" , 1); // specifying option
		return "admin";

	}
	
	@RequestMapping(value="/purchases" , method=RequestMethod.GET)
	public String displayAllPurchases(Model model)
	{
		List<?> purchaseList =  books.getBooks(2);	 // getting all purchases
		model.addAttribute("booksList" , purchaseList); // adding purchases to model
		model.addAttribute("option" , 2);  // specifying option
		return "admin";

	}
	
	@RequestMapping(value="/orders" , method=RequestMethod.GET)
	public String displayAllOrders(Model model)
	{
		List<?> ordersList =  books.getBooks(3);	// getting all orders
		model.addAttribute("ordersList" , ordersList);// adding orders to model
		model.addAttribute("option" , 3);
		return "admin";

	}


}
