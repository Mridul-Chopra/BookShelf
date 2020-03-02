package net.paxcel.bookshelf.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.paxcel.bookshelf.service.GetUserIdService;

@Controller
public class UserController {
	
	@Autowired Logger log;
	@Autowired GetUserIdService user;
	
	@RequestMapping("/user")
	public String user(HttpServletRequest request)
	{
		String email="";
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  if (!(auth instanceof AnonymousAuthenticationToken))
		  {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();	  // get user details
			email= userDetail.getUsername();		// get username
			
			try 
			{
			int id = user.getId(email);  // get id from db
			 request.getSession().setAttribute("id", id); // put in session
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		  }
		  
		  // redirect to required page
		 if(request.isUserInRole("ROLE_USER"))
			 return "redirect:order/"+email;
		 else 
			 return "redirect:admin";
	}

	
	@RequestMapping("/403")
	public String forbidden()
	{
		
		return "403";
	}

}

