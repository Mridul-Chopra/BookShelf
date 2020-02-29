package net.paxcel.bookshelf.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.paxcel.bookshelf.dao.GetBooksDAO;
import net.paxcel.bookshelf.model.BooksModel;
import net.paxcel.bookshelf.model.BooksResponse;

@Service
public class GetBooksServiceImpl implements GetBooksService{

	@Autowired Logger log;
	@Autowired GetBooksDAO books;
	final int total =5;
	@Override
	public BooksResponse getBooks(String data) {

		ResultSet result;
		BooksResponse booksDetails = new BooksResponse();
		Map<String,BooksModel> booksMap= new HashMap<String,BooksModel>();  // map to store book name and info 
		List<BooksModel> booksList = new ArrayList<BooksModel>(); // list of all books

		
		List<String> authors = new ArrayList<String>();
		List<String> genres = new ArrayList<String>();

		JSONObject jsonData = new JSONObject(data);
		JSONArray jauthors = jsonData.getJSONArray("authors");
		JSONArray jgenres = jsonData.getJSONArray("genres");
		int page = jsonData.getInt("page");
		
		

		for(int i=0;i<jauthors.length();i++)
		{
			authors.add(jauthors.getString(i));
		}
		for(int i=0;i<jgenres.length();i++)
		{
			genres.add(jgenres.getString(i));
		}

		try 
		{ 
			result = books.getBooks(authors,genres,page); // getting all books 
		}
		catch(Exception e) 
		{ return null; }


		try 
		{ 
			BooksModel book; 
			while(result.next()) 
			{ 
					String bookName =
					result.getString("BOOK_NAME"); // get book name
		
				// if book name is already present update the authors list
					if(booksMap.containsKey(bookName)) 
					{ 
						book = booksMap.get(bookName); 
						String author = result.getString("AUTHOR_NAME"); 
						book.addAuthor(author); 
					} 
					else // add new book info to books map 
					{ 
						String author =
						result.getString("AUTHOR_NAME"); String genre = result.getString("GENRE");
						float price = result.getFloat("PRICE"); int id = result.getInt("BOOK_ID");
			
						book= new BooksModel(); book.setGenre(genre); book.setPrice(price);
						book.addAuthor(author); book.setBookName(bookName); book.setId(id);
						booksMap.put(bookName, book); 
					}

			}

		Iterator<?> books = booksMap.entrySet().iterator(); 
		while(books.hasNext()) //coverting hasmap to list 
		{ 
			Map.Entry<String, BooksModel> mapValue=
			(Map.Entry<String, BooksModel>)books.next();

			booksList.add(mapValue.getValue());

		}
		
		List<BooksModel> tempbooksList = new ArrayList<BooksModel>();
		int start = (page-1)*total;
		int end = (page*total-1<=booksList.size()-1)?page*total-1:booksList.size()-1;
		
		for(int i=start;i<=end;i++)
		{
			tempbooksList.add(booksList.get(i));
		}
		
		float pages = (float)booksList.size()/total;
		pages = (pages-(int)pages)>0 ? (int)pages +1 : (int)pages;
		
		booksDetails.setTotalPages((int)pages);
		
		booksList = tempbooksList;
		
		
		booksDetails.setBooksList(booksList);
		
		return booksDetails; // returning list of books

		} 
		catch(Exception e) 
		{ log.error(this.getClass()+"-->> "+e); return null; }


	}

}
