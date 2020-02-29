package net.paxcel.bookshelf.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.paxcel.bookshelf.service.OrderService;


@Controller
public class PlaceOrderController {
	
	@Autowired Logger log;
	@Autowired OrderService order_;

	@RequestMapping(value="/orderDetails" , method=RequestMethod.POST)
	public @ResponseBody String my( @RequestBody String order , HttpServletRequest request)
	{
		int id = (Integer)request.getSession().getAttribute("id");
		
		boolean status = order_.addOrder(order , id);
			if(status)
			{
				return "Order placed successfully.."; 
			}
			
			else 
			{
				return "Some error occoured."; 
			}
		
	}
}
