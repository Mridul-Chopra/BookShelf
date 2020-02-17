package net.paxcel.bookshelf.dao;

import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

@Repository
/*
 * Interface to get all the Books from database
 * 
*/
public interface GetBooksDAO {
	
	@Deprecated
	public ResultSet getBooks() throws Exception; // function to get all books 
	public ResultSet getBooks(String author ,String genre) throws Exception; // function to get all books and books with filters

}
