package net.paxcel.bookshelf.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public interface InsertBooksDAO {

	// function to insert new books
	public Boolean insertBooks(String bookName , String date , int amount , ArrayList<String> authors , String genre, float price) ;
}
