package net.paxcel.bookshelf.dao;

import java.sql.ResultSet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
/*

	Implementation class of GetAuthorsDAO
*/
public class GetAuthorsDAOImpl implements GetAuthorsDAO{

	@Autowired QueryHelper sql; // custom query helper to execute queries
	@Autowired Logger log; //  logger
	
	
	@Override
	public ResultSet getAuthors() throws Exception
	{
		
		
		try 
		{
		ResultSet result;
		String statement = "SELECT * from AUTHORS"; // query to get data
		sql.setQuery= (Void)->{return Void;}; // setting query
		result = sql.getData(statement);	// getting data from user
		
		return result;
		}
		catch(Exception e)
		{
			log.error(this.getAuthors()+"-->> "+e);  // logging exception
			throw new Exception();
		}
	}
	

}
