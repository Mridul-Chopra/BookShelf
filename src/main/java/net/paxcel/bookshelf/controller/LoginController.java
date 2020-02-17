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
CheckLoginService login; // service layer method to check login

@Autowired
Logger log;
	
	
@RequestMapping(method = RequestMethod.GET)
public String login(Model model,@RequestParam(value = "message", required = false) String message)
{	
	LoginModel login = new LoginModel(); 
	model.addAttribute("userForm",login); // adding to model
	log.info(message);
	
	// display message if wrong message sent
	if(message!=null)
	{
		model.addAttribute("message","Wrong username or password"); 
	}
	return "login";
}

@RequestMapping(method = RequestMethod.POST)
public String checkLogin(@Valid @ModelAttribute("userForm") LoginModel details ,BindingResult result, Model model   )
{
	if(result.hasErrors())
	{
		return "login";
	}
	String page ="";
	try 
	{
		String email  = details.getEmail();
		String password = details.getPassword();
		log.info("Email :"+email);
		log.info("Password : "+password);
		
			/*
			 * int status = login.checkLogin(email,password);
			 * 
			 * if(status==2) { page="admin";
			 * 
			 * } else if(status==1) { page= "redirect:order/"+email+"/1";
			 * 
			 * 
			 * } else { model.addAttribute("message","Wrong username or password");
			 * page="login"; }
			 * 
			 */
		
	}
	catch(Exception e)
	{
		log.error(this.getClass()+"--->"+e);
	}
	return "login";
}

}
