package net.paxcel.bookshelf.dao;

import java.sql.ResultSet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GetGenresDAOImpl implements GetGenresDAO {

	@Autowired Logger log;  // getting logger 
	@Autowired QueryHelper sql; // custom sql helper
	
	@Override
	public ResultSet getGenres() throws Exception {
		
		try
		{
			String query ="Select Distinct GENRE from BOOKS ;"; 
			sql.setQuery= (Void)->{return Void;}; // setting query
			ResultSet result = sql.getData(query);  //getting result from DB
	
			return result;
		}
		catch(Exception e)
		{
			log.error(this.getClass()+"-->> "+e); // logging exception
			throw new Exception();
		}
	}

}
