package net.paxcel.bookshelf.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.paxcel.bookshelf.dao.RegisterUserDAO;

@Service
public class SignUpServiceImpl implements SignUpService{

@Autowired
Logger log;

@Autowired
RegisterUserDAO signup; // dao interface for signup
	
	@Override
	public String signup(String email, String password, String address) {
		
		Integer status = signup.enterUserData(email , password ,  address); // signing up user
		
		
		// giving message based upon status
		if(status == 1) // successful
		{
			return "Sign Up Successful. Please login to continue.";
		}
		else if(status ==-1)  // duplicate record
		{
			return "E-mail already registered. Please enter another email.";
		}
		else // unsuccessful
		{
			return "Some error occoured. Please try again later." ;
		}
	}

	
}
