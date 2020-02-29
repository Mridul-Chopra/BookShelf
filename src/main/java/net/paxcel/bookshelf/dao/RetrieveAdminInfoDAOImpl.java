package net.paxcel.bookshelf.dao;

import java.sql.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RetrieveAdminInfoDAOImpl implements RetrieveAdminInfoDAO {

	@Autowired
	QueryHelper sql;
	
	@Override
	public ResultSet retrieveBooks(int option) {
		
		ResultSet result ;
		String query = "";
		
		/*
		 *  setting query based on option
		*/
		switch(option)
		{
			case 1:
			{
				query = "Select * from BOOKS";
			break;
			}
			case 2:
			{
				query = "SELECT BOOK_NAME , QUANTITY , DATE_OF_PURCHASE  FROM BOOKS_PURCHASES INNER JOIN BOOKS WHERE BOOKS_PURCHASES.BOOK_ID = BOOKS.BOOK_ID" ; 
			break;
			}
			case 3:
			{
				query = "SELECT ORDERS.ORDER_ID , USERNAME , BOOK_NAME , QUANTITY , DATE_OF_ORDER FROM ORDERS INNER JOIN ORDER_SUMMARY  INNER JOIN BOOKS INNER JOIN USERS WHERE ORDERS.ORDER_ID = ORDER_SUMMARY.ORDER_ID AND BOOKS.BOOK_ID = ORDERS.BOOK_ID AND ORDER_SUMMARY.USER_ID = USERS.USER_ID"; 
			break;
			}
		}
		
		// setting query
		sql.setQuery=(Void)->
		{
			return Void;
		};
		
		 result = sql.getData(query);  // gtting data
		 return result;  //returning result
	}

}
