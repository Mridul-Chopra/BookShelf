package net.paxcel.bookshelf.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.paxcel.bookshelf.dao.GetBooksDAO;
import net.paxcel.bookshelf.model.BooksModel;

@Service
public class GetBooksServiceImpl implements GetBooksService{

	@Autowired Logger log;
	@Autowired GetBooksDAO books;
	@Override
	public List<BooksModel> getBooks(String authorName , String genreType) {
		
		ResultSet result;
		Map<String,BooksModel> booksMap= new HashMap<String,BooksModel>();  // map to store book name and info 
		List<BooksModel> booksList = new ArrayList<BooksModel>(); // list of all books
		
		try
		{
			result = books.getBooks(authorName, genreType); // getting all books
		}
		catch(Exception e)
		{
			return null;
		}
		
		
		try
		{
			BooksModel book;
			while(result.next())
			{
				String bookName = result.getString("BOOK_NAME"); // gett book name
				
				// if book name is already present update the authors list
				if(booksMap.containsKey(bookName))
				{
					book = booksMap.get(bookName);
					String author = result.getString("AUTHOR_NAME");
					book.addAuthor(author);
				}
				else // add new book info to books map
				{
					String author = result.getString("AUTHOR_NAME");
					String genre = result.getString("GENRE");
					float price = result.getFloat("PRICE");
					
					book= new BooksModel();
					book.setGenre(genre);
					book.setPrice(price);
					book.addAuthor(author);
					book.setBookName(bookName);
					
					booksMap.put(bookName, book);
				}
				
			}
			
			Iterator<?> books = booksMap.entrySet().iterator();
			while(books.hasNext()) // coverting hasmap to list
			{
				Map.Entry<String, BooksModel> mapValue= (Map.Entry<String, BooksModel>)books.next();
				
				booksList.add(mapValue.getValue());
				
			}
			
			return booksList; // returning list of books
			
		}
		catch(Exception e)
		{
			log.error(this.getClass()+"-->> "+e);
			return null;
		}
		
	}

}
