package net.paxcel.bookshelf.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.paxcel.bookshelf.model.BooksModel;
import net.paxcel.bookshelf.model.BooksResponse;
import net.paxcel.bookshelf.service.GetAuthorsService;
import net.paxcel.bookshelf.service.GetBooksService;
import net.paxcel.bookshelf.service.GetGenresService;

@Controller
public class OrderController {

	@Autowired
	GetAuthorsService authors;  //Service layer method to get all authors
	@Autowired
	GetGenresService genres;	//Service layer method to get all genres
	@Autowired
	GetBooksService books;     // //Service layer method to get all books
	@Autowired
	Logger log;		// getting logger
	
	  @RequestMapping(value = "/order/{email}/{page}" , method = RequestMethod.GET) 
	  public String setAuthorsAndGenres(
	  
	@PathVariable("email") String email, //getting email from url
	@PathVariable("page") int page , //page number for pagination  
	   Model model ) 
	  {
		  
	/*
	*  adding email and page to model 
	 */
	 model.addAttribute("email",email); 
	 model.addAttribute("page",page);
	 
	  List<String> authorsList = authors.getAuthors();  // getting all authors
	  List<String> genresList =genres.getGenres(); // getting all genres
	  
	  
	  
	  if(authorsList==null | genresList==null )
	  {
	  model.addAttribute("message","Some error occoured."); // display message if data not available due to error
	  
	  } 
	  else
	  {
		  model.addAttribute("authorsList",authorsList); 
		  model.addAttribute("genresList",genresList); 
	  }
	 
	  return "order";  // return view
	}
	 
	@RequestMapping(value = "/getBooks", method = RequestMethod.POST)
	public @ResponseBody BooksResponse filter(Model model, @RequestBody String data) 
	{	
			
		  return books.getBooks(data); 
	}
	
}
