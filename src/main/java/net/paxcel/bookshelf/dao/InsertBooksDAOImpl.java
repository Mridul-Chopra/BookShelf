package net.paxcel.bookshelf.dao;

import java.util.ArrayList;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InsertBooksDAOImpl implements InsertBooksDAO {

	@Autowired
	QueryHelper sql;  // custom query helper

	@Autowired Logger log; // getting logger

	Function<Void,Boolean> insertPurchasedBooks;  // function to be executed
	
	@Override
	public Boolean insertBooks(String bookName, String date, int amount, ArrayList<String> authors, String genre,float price) {
		
		insertPurchasedBooks =
		(x)->
		{
			sql.createSavepoint("point1");  // creating a save point
			String query = "Insert into BOOKS_PURCHASES values (? , ? , ?) ;";  // query to insert
			
			// setting parameters in query
			sql.setQuery = (Void)->
			{
				try {
					sql.st.setString(1,bookName);
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
					query = "Update BOOKS set STOCK = STOCK + ? where BOOK_NAME = ?"; // query to update stocks
					
					// setting query
					sql.setQuery = (Void)->
											{
												try {
													sql.st.setInt(1,amount);
													sql.st.setString(2,bookName);
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
					query = "Insert into BOOKS values (?,?,?,?)"; // setting query
					
					// setting query parameters
					sql.setQuery = (Void)->
											{
												try {
													sql.st.setString(1,bookName);
													sql.st.setInt(2,amount);
													sql.st.setString(3,genre);
													sql.st.setFloat(4, price);
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

					query ="Insert into BOOKS_AUTHORS values ";
					
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
												try {
												for(int i=1;i<=authors.size()*2;i++)
												{
													if(i%2!=0)
													{
														sql.st.setString(i,bookName);
													}
													else
													{
													
														sql.st.setString(i,authors.get(i/2 -1));
														
													}
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
					sql.save(); // commit 
				
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

}
