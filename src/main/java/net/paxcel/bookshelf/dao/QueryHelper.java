package net.paxcel.bookshelf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import net.paxcel.bookshelf.dbUtils.Pool;

@Repository
/*

		Custom helper clas to perform data retrieval , insertion or transaction operations
*/
public class QueryHelper {
	
	@Autowired	private Pool pool;  // Connection pool
	@Autowired 	private Logger log; // logger
				public Connection cn ; // connection object 
				public PreparedStatement st; // statement to be executed
				private ResultSet rs; // result to be returned
				public Function<Void , Void>  setQuery ; // function to set queries in statement
				private Void x; 
				private Map<String,Savepoint> savepoints = new HashMap<String,Savepoint>(); // map to save the savepoints with names given by caller
				
	
				

	
	// function to perform retrieval from database			
	private Function<String,ResultSet> performRetrievalOperation = (sql) ->{
		
		try
		{
			
			cn = pool.get(); // getting connection from pool
			rs=null; 
			
			st = cn.prepareStatement(sql); // preparing the statement
			
			setQuery.apply(x); // executing the set query
			
			rs = st.executeQuery(); // executing sql
			
		} 
		catch (Exception e)
		{
			log.error(this.getClass()+"--->"+e); // logging the exception
		}
		
		finally
		{
			pool.returnBack(cn);  // returning connection to pool
		}
		return rs; // returning result
	};
	
	
	
	// function to perform single insertion
	private Function<String, Integer> performInsertionOperation = (sql)->{
		
		Integer status;  // status of insert
		try 
		{
			  
			cn = pool.get(); // getting connection from pool
			st = cn.prepareStatement(sql); // preparing th statement
			setQuery.apply(x); // executing the set query
			st.executeUpdate(); // performing insertion
			
			
			status = 1;  // successful status
			
		}
		catch(java.sql.SQLIntegrityConstraintViolationException ex)
		{
			log.error(this.getClass()+"--->"+ex);
			status = -1; // duplicte record status
		}
		catch(Exception e)
		{
			log.error(this.getClass()+"--->"+e);
			status = 0; // unsuccessful status
		}
		finally
		{
			pool.returnBack(cn);  // returning connection to pool
		}
			return status; // returning status
	};
	
	
	
	/*
	 *  visble function to get data from database
	*/
	public ResultSet getData(String statement )
	{
		
		return performRetrievalOperation.apply(statement); // performing the retrieval
	}
	
	
	/*
	 *  visble function to set data into database
	*/
	public Integer setData(String statement)
	{
		
		return performInsertionOperation.apply(statement); // performing the update
	}
	
	
	
	/**
	 *  function to perform transactions
	 *  
	 * @param operations : a function to perform operations
	 * @return
	 */
	public boolean performTransactions(Function<Void , Boolean> operations)
	{
	
			savepoints.clear(); // clearing all savepoints for fresh transaction
			try 
			{
				cn.setAutoCommit(false); // custom commit enabled
			} 
			catch (SQLException e) 
			{
				log.error(this.getClass()+"--->"+e); // logging error
			}
		
			Boolean isSuccessfull = operations.apply(x); // executing transactions and getting status
			return isSuccessfull; // return success status
	}
	
	
	// function to perform commit
	public void save()
	{
		try 
		{
			cn.commit();
		} 
		catch (SQLException e) 
		{
			log.error(this.getClass()+"--->"+e);
		}
	}
	
	// functon to create savepoint with specified names
	public void createSavepoint(String name)
	{
		 try 
		 {
			Savepoint savepoint = cn.setSavepoint(name);
			savepoints.put(name, savepoint);
			log.info(savepoints);
		 } 
		 catch (SQLException e) 
		 {
			log.error(this.getClass()+"--->"+e);
		 }
	}
	
	// function to roll back
	public void rollBackto(String savepoint)
	{
		Savepoint rollbackpoint = savepoints.get(savepoint);
		try 
		{
			cn.rollback(rollbackpoint);
		} 
		catch (SQLException e)
		{
			log.error(this.getClass()+"--->"+e);
		}
	}
}
