package net.paxcel.bookshelf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class GetBooksDAOImpl implements GetBooksDAO{

	@Autowired Logger log;  // getting logger
	@Autowired QueryHelper sql; // getting custom query helper
	private String query;
	@Override
	@Deprecated
	public ResultSet getBooks() throws Exception {
		
		try
		{
		ResultSet result;
		
		// query to be executed to get data
		String query = "SELECT BOOKS.BOOK_NAME ,BOOKS.BOOK_ID, GENRE , PRICE , AUTHOR_ID FROM BOOKS INNER JOIN BOOKS_AUTHORS_MAP WHERE BOOKS.BOOK_ID = BOOKS_AUTHORS_MAP.BOOK_ID ORDER BY BOOKS.BOOK_NAME ;";
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
			String query = "SELECT BOOKS.BOOK_NAME ,BOOKS.BOOK_ID ,GENRE , PRICE , AUTHORS.AUTHOR_NAME FROM BOOKS INNER JOIN BOOKS_AUTHORS_MAP INNER JOIN AUTHORS WHERE BOOKS.BOOK_ID = BOOKS_AUTHORS_MAP.BOOK_ID AND BOOKS_AUTHORS_MAP.AUTHOR_ID = AUTHORS.AUTHOR_ID";
		
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

	@Override
	public ResultSet getBooks(List<String> authors, List<String> genres, int page) throws Exception {
		try
		{
			ResultSet result;
			 query = "SELECT BOOKS.BOOK_NAME ,BOOKS.BOOK_ID ,GENRE , PRICE , AUTHORS.AUTHOR_NAME FROM BOOKS INNER JOIN BOOKS_AUTHORS_MAP INNER JOIN AUTHORS WHERE BOOKS.BOOK_ID = BOOKS_AUTHORS_MAP.BOOK_ID AND BOOKS_AUTHORS_MAP.AUTHOR_ID = AUTHORS.AUTHOR_ID";
			
			 if(authors.size()<=0 | genres.size() <=0)
			 {
				 return null;
			 }
			if(!authors.get(0).equals("all"))
			{
				query+=" AND AUTHOR_NAME IN(";
				for(int i =0;i<=authors.size()-2;i++)
				{
					query+="'"+authors.get(i)+"',";
				}
				query+="'"+authors.get(authors.size()-1)+"')";
				log.info(query);
			}
			if(!genres.get(0).equals("all"))
			{
				query+=" AND GENRE IN(";
				for(int i =0;i<=genres.size()-2;i++)
				{
					query+="'"+genres.get(i)+"',";
				}
				query+="'"+genres.get(genres.size()-1)+"')";
				log.info(query);
			}
			
			sql.setQuery=(Void)->{return Void;};
			return sql.getData(query);
		}
		catch(Exception e)
		{
			log.error(this.getClass()+"-->> "+e);
			throw new Exception();
		}
		
	}

	@Override
	public ResultSet getBooks(String bookName) throws Exception {
		
		ResultSet result;
		query = "SELECT BOOKS.BOOK_NAME ,BOOKS.BOOK_ID ,GENRE , PRICE , AUTHORS.AUTHOR_NAME FROM BOOKS INNER JOIN BOOKS_AUTHORS_MAP INNER JOIN AUTHORS WHERE BOOKS.BOOK_ID = BOOKS_AUTHORS_MAP.BOOK_ID AND BOOKS_AUTHORS_MAP.AUTHOR_ID = AUTHORS.AUTHOR_ID and BOOKS.BOOK_NAME LIKE ? ";
		
		sql.setQuery=(Void)->
							{
								try
								{
									sql.st.setString(1,bookName+"%");
								} 
								catch (SQLException e) 
								{
									log.error(this.getClass()+"-->> "+e);
								}
								return Void;
							};
		return sql.getData(query);
	}
	
	

}
