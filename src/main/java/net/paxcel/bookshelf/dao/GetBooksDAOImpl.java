package net.paxcel.bookshelf.dao;

import java.sql.ResultSet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class GetBooksDAOImpl implements GetBooksDAO{

	@Autowired Logger log;  // getting logger
	@Autowired QueryHelper sql; // getting custom query helper
	
	@Override
	public ResultSet getBooks() throws Exception {
		
		try
		{
		ResultSet result;
		
		// query to be executed to get data
		String query = "SELECT BOOKS.BOOK_NAME , GENRE , PRICE , AUTHOR_NAME FROM BOOKS INNER JOIN BOOKS_AUTHORS WHERE BOOKS.BOOK_NAME = BOOKS_AUTHORS.BOOK_NAME ORDER BY BOOKS.BOOK_NAME ;";
		sql.setQuery=(Void)->
							{
								return Void;
							};  // setting query
		
		result = sql.getData(query);  // getting data
		
		return result;
		}
		catch(Exception e)
		{
			log.error(this.getClass()+"-->> "+e); // logging exception
			throw new Exception();
		}
		
	}

	@Override
	public ResultSet getBooks(String author, String genre) throws Exception {
		
		try 
		{
			ResultSet result;
			// setting the query to get data
			String query = "SELECT BOOKS.BOOK_NAME , GENRE , PRICE , AUTHOR_NAME FROM BOOKS INNER JOIN BOOKS_AUTHORS WHERE BOOKS.BOOK_NAME = BOOKS_AUTHORS.BOOK_NAME  ";
		
	 		// modifying query based on filters
			if( author!=null & genre!=null)
			{
				query +=" AND  AUTHOR_NAME = ?  AND GENRE = ? ;";
				
				/*
				 * setting parameters in query
				 * 
				 */
				sql.setQuery=(Void)->
				{
					try 
					{
						sql.st.setString(1, author);
						sql.st.setString(2,genre);
					}
					catch(Exception e)
					{
						log.error(this.getClass()+"-->> "+e);
					}
					return Void;
				};

			}
			else if(genre!=null)
			{
				query +=" and Genre = ? ;";

				/*
				 * setting parameters in query
				 * 
				 */
				sql.setQuery=(Void)->
				{
					try 
					{
						sql.st.setString(1,genre);
					}
					catch(Exception e)
					{
						log.error(this.getClass()+"-->> "+e);
					}
					return Void;
				};
			}
			else if(author!=null)
			{
				query +=" and  AUTHOR_NAME = ? ;";
				

				/*
				 * setting parameters in query
				 * 
				 */
				sql.setQuery=(Void)->
				{
					try 
					{
						sql.st.setString(1, author);
					}
					catch(Exception e)
					{
						log.error(this.getClass()+"-->> "+e);
					}
					return Void;
				};
			}
			else 
			{
				sql.setQuery=(Void)->
				{
					return Void;
				};
			}
			
			result = sql.getData(query);  // getting data from data base
			
			return result; // returning result as ResultSet
						
			
		}
		catch(Exception e)
		{
			log.error(this.getClass()+"-->> "+e);
			throw new Exception();
		}
	}
	
	

}
