package net.paxcel.bookshelf.dao;

import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

@Repository
public interface RetrieveAdminInfoDAO {

	
	/**
	 * retrive data required by admin
	 * 
	 * @param option : species type of data to get
	 * @return
	 */
	public ResultSet retrieveBooks(int option);
}
