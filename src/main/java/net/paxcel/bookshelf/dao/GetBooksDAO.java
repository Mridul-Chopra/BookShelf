package net.paxcel.bookshelf.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
/*
 * Interface to get all the Books from database
 * 
*/
public interface GetBooksDAO {
	
	@Deprecated
	public ResultSet getBooks() throws Exception; // function to get all books 
	@Deprecated
	public ResultSet getBooks(String author ,String genre) throws Exception; // function to get all books and books with filters
	
	public ResultSet getBooks(List<String>authors,List<String>genres,int page)throws Exception;
	public ResultSet getBooks(String bookName)throws Exception;
}
