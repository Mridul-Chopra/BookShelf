package net.paxcel.bookshelf.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import net.paxcel.bookshelf.dao.QueryHelper;
@Repository
public class InsertBooksDAOImpl implements InsertBooksDAO {

	@Autowired
	QueryHelper sql;  // custom query helper

	@Autowired Logger log; // getting logger

	Function<Void,Boolean> insertPurchasedBooks;  // function to be executed
	
	int bookId;
	ArrayList<Integer> authorIds = new ArrayList<Integer>();

	@Override
	public Boolean insertBooks(String bookName, String date, int amount, ArrayList<String> authors, String genre,float price) {
		
		
		
		insertPurchasedBooks =
		(x)->
		{
			sql.createSavepoint("point1");  // creating a save point
			
			try 
			{
				
				bookId = getBookId(bookName);
			} 
			catch (Exception e1) 
			{
				log.error(this.getClass()+"---> === "+e1);
				return false;
			}
			
			String query = "Insert into BOOKS_PURCHASES values (? , ? , ?) ;";  // query to insert
			
			// setting parameters in query
			sql.setQuery = (Void)->
			{
				try {
					sql.st.setInt(1,bookId);
					sql.st.setInt(2,amount);
					sql.st.setString(3,date);
				}
				catch(Exception e)
				{
					log.error(this.getClass()+"---> === "+e);
				}
				return Void;
			};
	
			if(sql.setData(query)!=1) // if update unsuccessful
			{
				sql.rollBackto("point1"); // if unsuccessful roll back to safe point
				return false;  // return if unsuccessful
			}
			else
				sql.save();  // commit if successful
			
			query = "Select * from BOOKS where BOOK_NAME =  ?";  // query to get inserted book from db
			
			// setting the query
			sql.setQuery = (Void)->
			{
				try {
					sql.st.setString(1,bookName);
				}
				catch(Exception e)
				{
					log.error(this.getClass()+"--->"+e);
				}
				return Void;
			};
	
			try {
				if(sql.getData(query).next()) // if some data is available in result then update stocks
				{
					query = "Update BOOKS set STOCK = STOCK + ? where BOOK_ID = ?"; // query to update stocks
					
					// setting query
					sql.setQuery = (Void)->
											{
												try {
													sql.st.setInt(1,amount);
													sql.st.setInt(2,bookId);
												}
												catch(Exception e)
												{
													log.error(this.getClass()+"--->"+e);
												}
												return Void;
											};
					if(sql.setData(query)!=1)  // if update unsuccessful
					{
						sql.rollBackto("point1"); // if unsuccessful roll back to safe point
						return false;  // return if unsuccessful
					}
					else
						sql.save();	// commit changes

				}

				else  // if no data found inset new entry in BOOKS and BOOKS_AUTHORS tables
				{
					query = "Insert into BOOKS values (?,?,?,?,?)"; // setting query
					
					// setting query parameters
					sql.setQuery = (Void)->
											{
												try {
													sql.st.setInt(1,bookId);
													sql.st.setString(2,bookName);
													sql.st.setInt(3,amount);
													sql.st.setString(4,genre);
													sql.st.setFloat(5, price);
												}
												catch(Exception e)
												{
													log.error(this.getClass()+"--->"+e);
												}
												return Void;
											};

					if(sql.setData(query)!=1) // if update unsuccessful
					{
						sql.rollBackto("point1"); // if unsuccessful roll back to safe point
						return false;  // return if unsuccessful
					}
					else
						sql.save(); // commit

					
					
					query ="Insert IGNORE into AUTHORS(AUTHOR_NAME) values ";
					for(int i=1;i<=authors.size()-1;i++)
					{
						query +="(?) , ";
					}
					query+="(?) ;";
					
					sql.setQuery= (Void)->
											{
												try 
												{
													for(int i=1;i<=authors.size();i++)
													{
															sql.st.setString(i,authors.get(i -1));
													}
												}
												catch(Exception e)
												{
													log.error(this.getClass()+"--->"+e);
												}
												return Void;
											};
					if(sql.setData(query)!=1)
					{
						sql.rollBackto("point1"); // if unsuccessful roll back to safe point
						return false;  // return if unsuccessful
					}
					else
					{
						sql.save(); // commit 
					}
				
					
					
					authorIds = getAuthorIds(authors);
				
					query ="Insert into BOOKS_AUTHORS_MAP values ";
					
					/*
					 *  Logic to create query for multiple author entry
					*/
					for(int i=1;i<=authors.size()-1;i++)
					{
						query +="(?,?) , ";
					}
					query+="(?,?) ;";
					
					
					// setting the query
					sql.setQuery= (Void)->
											{
												try 
												{
													for(int i=1;i<=authors.size();i++)
													{
															sql.st.setInt(i,bookId);
															sql.st.setInt(2*i,authorIds.get(i -1));
													}
												}
												catch(Exception e)
												{
													log.error(this.getClass()+"--->"+e);
												}
												return Void;
											};
					if(sql.setData(query)!=1)
					{
						sql.rollBackto("point1"); // if unsuccessful roll back to safe point
						return false;  // return if unsuccessful
					}
					else
					{
						sql.save(); // commit 
					}
				}
			} 
			catch (Exception e) 
			{
				
				log.error(this.getClass()+"--->"+e); // logging the error
				return false;
			}
			return true;
							
		};
		Boolean successful =  sql.performTransactions(insertPurchasedBooks);
		if(!successful)
		{ 
			sql.rollBackto("point1"); // if unsuccessful roll back to safe point
		}
		
		return successful;
	}
	
	
	private int getBookId(String bookName) throws Exception
	{
		String query = "SELECT  *  FROM (SELECT BOOK_ID  FROM BOOKS WHERE BOOK_NAME= ?  UNION SELECT IFNULL(MAX(BOOK_ID)+1, 1) FROM BOOKS )X LIMIT 0,1";
		sql.setQuery=(Void)->{
								try
								{
									sql.st.setString(1, bookName);
								}
								catch(Exception e)
								{
									log.error(this.getClass()+"--->"+e); // logging the error
								}
								return Void;
							};

		ResultSet result = sql.getData(query);
		result.next();					
		return result.getInt("BOOK_ID");
	}
	
	private ArrayList<Integer> getAuthorIds(ArrayList authorName) throws Exception
	{
		ArrayList<Integer>  authorIds = new ArrayList<Integer>();
		String query = "Select AUTHOR_ID from AUTHORS where AUTHOR_NAME IN ( ";
		
		for(int i=1;i<authorName.size()-1;i++)
		{
			query+="? ,";
		}
		
		query += "? ) ;";
		
		sql.setQuery=(Void)->{
								try
								{
									for(int i=1;i<=authorName.size();i++)
									{
										sql.st.setString(i,authorName.get(i-1).toString());
									}
									
								}
								catch(Exception e)
								{
									log.error(this.getClass()+"--->"+e); // logging the error
								}
								return Void;
							};

		ResultSet rs = sql.getData(query); 
		while(rs.next())
		{
			authorIds.add(rs.getInt("AUTHOR_ID"));
		}
		
		return authorIds;
	}
}
