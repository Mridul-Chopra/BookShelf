package net.paxcel.bookshelf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.paxcel.bookshelf.model.AddBooksModel;
import net.paxcel.bookshelf.model.SignUpModel;
import net.paxcel.bookshelf.service.InsertBooksService;

@Controller
@RequestMapping(value="/add")
public class AddBooksController {
	
	@Autowired
	InsertBooksService insert;  // Service layer interface

	@RequestMapping(method=RequestMethod.GET)
	public String addBooksPage(Model model)
	{
		AddBooksModel user = new AddBooksModel();  
        model.addAttribute("userForm", user);   // making model and adding to view to save results user enters
		return "add";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addBooks(@Valid @ModelAttribute("userForm") AddBooksModel books,BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			return "add";  // terminate if invalid data is entered
		}
		
		
		/*
		 * getting data entered by user
		*/
		String bookName = books.getBookName();  
		String genre = books.getGenre();
		ArrayList<String> author = (ArrayList)books.getAuthor();
		float price = books.getPrice();
		String date = books.getDate();
		int amount = books.getAmount();
		
		Boolean status = insert.insertBooks(bookName, date, amount, author, genre, price);  // status : inserted or not
		
		
		// Giving feedback based on status
		if(status)
		{
			model.addAttribute("result","Succesfully Inserted");   
		}
		else
		{
			model.addAttribute("result","Some error Occoured");
		}
		return "add";  // returning view
	}
	
}
