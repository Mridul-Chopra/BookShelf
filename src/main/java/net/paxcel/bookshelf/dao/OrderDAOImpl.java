package net.paxcel.bookshelf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDAOImpl implements OrderDAO{

	@Autowired private QueryHelper sql;
	@Autowired private Logger log;
	private Function<Void,Boolean> placeOrder;
	int id;
	
	@Override
	public boolean placeOrder(Map<Integer, Integer> books , int user_id)  {
		
		placeOrder = 
		(x)->
		{
			sql.createSavepoint("point1");
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
			Date date = new Date();
			
			String query = "Insert into ORDER_SUMMARY(USER_ID,DATE_OF_ORDER) values (?,?)";
			sql.setQuery=(Void)->
								{
									try 
									{
										sql.st.setInt(1,user_id);
										sql.st.setString(2, dateFormat.format(date));
									} 
									catch ( Exception e) 
									{
										log.error(this.getClass()+"-->>"+e);
									}
										return Void;
								};
								
								
			if(sql.setData(query)!=1) 		// if update unsuccessful
			{
				sql.rollBackto("point1"); 	// if unsuccessful roll back to safe point
				return false;  				// return if unsuccessful
			}
			else
			{
				sql.save();  				// commit if successful
			}
				
				
			query = "Select MAX(ORDER_ID) as ID from ORDER_SUMMARY;";
			sql.setQuery=(Void)->{return Void;};
			
			ResultSet result = sql.getData(query);
			
			try 
			{
				if(result.next())
				{
					id=result.getInt("ID");
				}
			} 
			catch (SQLException e) 
			{
				log.error(this.getClass()+"-->>"+e);
			}
			
			
			ArrayList<Integer> bookslist =  new ArrayList<Integer>(books.keySet());
			ArrayList<Integer> quantity =  new ArrayList<Integer>(books.values());

			query="Insert into ORDERS values";
			for(int i=1;i<=books.size()-1;i++)
			{
				query+="(? , ? , ? ) , ";
			}
			query+="(?,?,?) ;";
			sql.setQuery= (Void)->
									{
										for(int i=1;i<=books.size()*2;i++)
										{
												try 
												{
													sql.st.setInt((3*i-2),id);
													sql.st.setInt((3*i-1),bookslist.get(i-1));
													sql.st.setInt((3*i),quantity.get(i-1));
												}
										
												catch (SQLException e) 
												{
													log.error(this.getClass()+"-->>"+e);
												}
										}
											
										return Void;
									};
			if(sql.setData(query)!=1) 		// if update unsuccessful
			{
				sql.rollBackto("point1"); 	// if unsuccessful roll back to safe point
				return false;  				// return if unsuccessful
			}
			else
			{
				sql.save();  				// commit if successful
			}
			
			return true;
		};
		
		
		boolean status = sql.performTransactions(placeOrder);
		return status;
		
		
	}

}
