package net.paxcel.bookshelf.controller;

import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import net.paxcel.bookshelf.model.SignUpModel;
import net.paxcel.bookshelf.service.SignUpService;

@Controller
@RequestMapping(value = "/signup")
public class SignUpController {

//	@Autowired
//	Logger log; // getting logger

	@Autowired
	SignUpService signup; // service layer to sign up user

	@RequestMapping(method = RequestMethod.GET)
	public String signupPage(Map<String, Object> model) {
		SignUpModel user = new SignUpModel();
		model.put("userForm", user); // making model and adding to view to save results user enters
		return "signup";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processSignup(@Valid @ModelAttribute("userForm") SignUpModel details, BindingResult result,
			Map<String, Object> model, Model status) {
		/*
		 * if errors in data entered terminate
		 */
		if (result.hasErrors()) {
			return "signup";
		}

		/*
		 * Getting data entered by user
		 */
		String email = details.getEmail();
		String password = details.getPassword();
		String address = details.getAddress();

		System.out.print(password);
		
		String message = signup.signup(email,"123456",address); // signing up user and getting status message
		status.addAttribute("message", message); // displaying messaging from user
		return "signup";
	}
}
