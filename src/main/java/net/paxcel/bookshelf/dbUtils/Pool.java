package net.paxcel.bookshelf.dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;




/**
 * @author Mridul
 *
 */

public class Pool
{
	
private  Queue<Connection> pool = new LinkedList<Connection>();  // Contains all Connection Objects 
private  String url_ , username_ , password_ , driver_;   // contains connection information
private  boolean isSet = false; 							// checks if properties were already set or not
private  int numberOfWaitingProcesses = 0;               // contains count of waiting processes
private  int maxLimit = 10;								// maximum number of connections in pool
private  int minLimit = 5;								// minimum number of connections in pool
private  int 	maxWaitngProcesses = 3;						// maximum number of processes that can wait
	
@Autowired
Logger log;




	/**
	 * @return  :  returns Connection object
	 */
	public  synchronized Connection get()
	{
		if(pool.peek() == null)
			numberOfWaitingProcesses++; // increasing the count of waiting processes
		
		if(numberOfWaitingProcesses<=maxWaitngProcesses)
			while(pool.peek()==null);    // busy waiting if no connection is available
		else
		{
			if(!createMoreConnections())    // create more connections if not max limit reached
				while(pool.peek()==null);	// busy waiting if max limit reached
		}
		return pool.remove();		// returning connection object and removing from queue
	}
	
	
	/**
	 * @param cn  : getting back connection and inserting to pool
	 */
	public  void returnBack(Connection cn)
	{

		pool.add(cn);		// adding connection to pool
		
	}
	
	/**
	 * 
	 */
	public   void establishPool() throws Exception // just to run the  block
	{	
		if(isSet)
		{
			log.error("Pool Properties were already set. Can only set once");
			throw new Exception();
		}
		
		
		
		try
		{
			
			Class.forName(driver_);		 // loading the DriverManager
			for(int i =1 ; i<=minLimit ;i++)
			{
				Connection conn = DriverManager.getConnection(url_,username_,password_); // establishing connection 
				pool.add(conn);		// adding connection  to queue
			}
		}
		catch(Exception e)
		{
			log.error(e);							// logging the error
			System.out.println("Fatal Error. Exiting");     // Reporting to user
			System.exit(0);									// exiting the system
		}
	}
	
	

	/**
	 * 
	 */
	public  void deletePool()  // function to delete all connections in pool
	{	
		
		  pool.stream().forEach(i->
		  {
			  try { i.close(); }
		  
			  catch (SQLException e) 
			  	{ log.error(e); } 
		  });
		  
		 
		pool.clear();		// deleting all the elements of pool
		
	}
	
	/**
	 * 
	 */
	public  boolean createMoreConnections() // to create additional connections
	{
		try
		{
			if(pool.size() >= maxLimit )
				return false;
			
			Class.forName(driver_);		 // loading the DriverManager
			for(int i =1 ; i<=3 ;i++)
			{
				Connection conn = DriverManager.getConnection(url_,username_,password_); // establishing connection 
				pool.add(conn);		// adding connection  to queue
			}
			
			
		}
		catch(Exception e)
		{
			log.error(e);							// logging the error
		}
			
			return true;
		
	}
	
	
	/*		
	 * 
	 *   GETTERS AND SETTERS START
	 *
	 * -----------------------------------------------------------------------------------
	 */
	
	public  int getMinLimit() {
		return minLimit;
	}


	public  void setMinLimit(int minLimitP) throws Exception {
		if(isSet)
		{
			log.error("Pool Properties were already set. Can only set once");
			throw new Exception();
		}
		else if(minLimit <0 )
		{
			log.error("Maximum Limit of connections in pool cannot be zero");
			throw new Exception();
		}
		minLimit = minLimitP;
	}


	public  int getMaxLimit_() {
		return maxLimit;
	}


	public  void setMaxLimit(int maxLimitP) throws Exception
	{	
		if(isSet)
		{
			log.error("Pool Properties were already set. Can only set once");
			throw new Exception();
		}
		
		else if(maxLimit <0 )
		{
			log.error("Maximum Limit of connections in pool cannot be zero");
			throw new Exception();
		}
		maxLimit = maxLimitP;
	}


	public  int getMaxWaitngProcesses() {
		return maxWaitngProcesses;
	}


	public  void setMaxWaitngProcesses(int maxWaitngProcesses) {
		
		this.maxWaitngProcesses = maxWaitngProcesses;
	}


	public String getUrl_() {
		return url_;
	}


	public void setUrl_(String url_) {
		this.url_ = url_;
	}


	public String getUsername_() {
		return username_;
	}


	public void setUsername_(String username_) {
		this.username_ = username_;
	}


	public String getPassword_() {
		return password_;
	}


	public void setPassword_(String password_) {
		this.password_ = password_;
	}


	public String getDriver_() {
		return driver_;
	}


	public void setDriver_(String driver_) {
		this.driver_ = driver_;
	}
	
	
	

	/*		
	 * 
	 *   GETTERS AND SETTERS END
	 *
	 * -----------------------------------------------------------------------------------
	 */
	
	
}
