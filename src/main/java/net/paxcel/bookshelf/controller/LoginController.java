package net.paxcel.bookshelf.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.paxcel.bookshelf.model.LoginModel;
import net.paxcel.bookshelf.service.CheckLoginService;

@Controller
@RequestMapping(value = "/login")

public class LoginController {
	

@Autowired
Logger log;
	
	
@RequestMapping(method = RequestMethod.GET)
public String login(Model model,@RequestParam(value = "message", required = false) String message,@RequestParam(value = "logout", required = false) String logout)
{	
	LoginModel login = new LoginModel(); 
	model.addAttribute("userForm",login); // adding to model
	log.info(message);
	
	// display message if wrong message sent
	if(message!=null)
	{
		model.addAttribute("message","Wrong username or password"); 
	}
	if(logout!=null)
	{
		model.addAttribute("message","Logout Successful"); 
	}
	return "login";
}


}
