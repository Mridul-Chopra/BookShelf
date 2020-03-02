package net.paxcel.bookshelf.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Qualifier("insertBooks2")
@Repository
public class InserBooksDAOImpl2 implements InsertBooksDAO {

	@Autowired private QueryHelper sql;
	@Autowired Logger log;
	Function<Void,Boolean> insertPurchasedBooks;  // function to be executed
	@Override
	public Boolean insertBooks(String bookName, String date, int amount, ArrayList<String> authors, String genre,float price) 
	{
		insertPurchasedBooks =
		(x)->
		{
			sql.createSavepoint("point1");  // creating a save point
			
			String query = "REPLACE INTO books(book_name,stock,genre, price)" + 
							"SELECT book_name,stock+? AS stock ,genre,price  FROM books WHERE book_Name = ? UNION SELECT ?,?,?,?  LIMIT 0,1";
			
			sql.setQuery=(Void)->
								{
									try 
									{
										sql.st.setInt(1, amount);
										sql.st.setString(2,bookName);
										sql.st.setString(3,bookName);
										sql.st.setInt(4, amount);
										sql.st.setString(5,genre);
										sql.st.setFloat(6, price);
									} 
									catch (SQLException e) 
									{
										log.error(e);
									}
									return Void;
								};
			if(sql.setData(query)!=1) // if update unsuccessful
			{
				sql.rollBackto("point1"); // if unsuccessful roll back to safe point
				return false;  // return if unsuccessful
			}
			else
			{
				sql.save();
			}
		
		
			query="INSERT INTO books_purchases " + 
					"SELECT book_id,?,? FROM books WHERE book_name = ?";
			sql.setQuery = (Void)->
									{
										try
										{
											sql.st.setInt(1,amount);
											sql.st.setString(2,date);
											sql.st.setString(3, bookName);
										}
										catch(SQLException e)
										{
											log.error(e);
										}
										return Void;
									};
			if(sql.setData(query)!=1) // if update unsuccessful
			{
				sql.rollBackto("point1"); // if unsuccessful roll back to safe point
				return false;  // return if unsuccessful
			}
			else
			{
				sql.save();
			}
			
			
			query="INSERT IGNORE INTO AUTHORS(Author_name) VALUES";
			for(int i=1;i<=authors.size()-1;i++)
			{
				query+="(?),";
			}
			query+="(?) ;";
			
			sql.setQuery=(Void)->
								{
									try 
									{
										for(int i=1;i<=authors.size();i++)
										{
											sql.st.setString(i, authors.get(i-1));
										}
									}
									catch(SQLException e)
									{
										log.error(e);
									}
									return Void;
								};
			if(sql.setData(query)!=1) // if update unsuccessful
			{
				sql.rollBackto("point1"); // if unsuccessful roll back to safe point
				return false;  // return if unsuccessful
			}
			else
			{
				sql.save();
			}
			
			query="INSERT INTO books_authors_map (book_id,author_id) " + 
					"SELECT * FROM " + 
					"(SELECT book_id FROM books WHERE book_name = ? ) t1 " + 
					"INNER JOIN " + 
					"(SELECT author_id  FROM AUTHORS WHERE author_name IN( ";
			
			for(int i=1;i<=authors.size()-1;i++)
			{
				query+="?,";
			}
			query+="? ) ) t2;";
		
			sql.setQuery =(Void)->
									{
										try
										{
											sql.st.setString(1,bookName);
											
											for(int i=1;i<=authors.size();i++)
											{
												sql.st.setString(i+1 , authors.get(i-1) );
											}
										}
										catch(SQLException e)
										{
											log.error(e);
										}
										return Void;
									};
			if(sql.setData(query)!=1) // if update unsuccessful
			{
				sql.rollBackto("point1"); // if unsuccessful roll back to safe point
				return false;  // return if unsuccessful
			}
			else
			{
				sql.save();
			}
			
			return true;
		};
	
		return sql.performTransactions(insertPurchasedBooks);
		
	}

}
