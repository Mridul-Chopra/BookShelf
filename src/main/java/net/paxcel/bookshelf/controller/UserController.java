package net.paxcel.bookshelf.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@RequestMapping("/user")
	public String user()
	{
		String email="";
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  if (!(auth instanceof AnonymousAuthenticationToken))
		  {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();	
			email= userDetail.getUsername();
		  }
		 
		return "redirect:order/"+email+"/1";
	}

}
