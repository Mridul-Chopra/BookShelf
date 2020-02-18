package net.paxcel.bookshelf.controller;

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
	public @ResponseBody String my(@RequestParam("email") String email , @RequestBody String order)
	{
		
		int status = order_.addOrder(order , email);
			if(status==1)
			{
				return "Order placed successfully.."; 
			}
			
			else if(status==0)
			{
				return "Some error occoured."; 
			}
			else if(status==-1)
			{
				return "Looks like you are exploiting a vulnerability. We won't let you do it.....HAHAHA";
			}
			else
			{
				return "Something unexpected Occoured";
			}
		
	}
}
