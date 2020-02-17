package net.paxcel.bookshelf.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.paxcel.bookshelf.dao.InsertBooksDAO;

@Service
public class InsertBooksServicelmpl implements InsertBooksService{

	@Autowired
	InsertBooksDAO insert; // dao class to insert
	
	@Override
	public Boolean insertBooks(String bookName , String date , int amount , ArrayList<String> authors , String genre, float price) 
	{
		return insert.insertBooks(bookName , date ,  amount ,  authors , genre,  price) ; // inserting all books and returning status
		
	}
	
}
