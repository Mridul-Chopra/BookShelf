package net.paxcel.bookshelf.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;



@Service
public interface InsertBooksService {
	
	// function to insert all books
	public Boolean insertBooks(String bookName , String date , int amount , ArrayList<String> authors , String genre, float price) ;
}
