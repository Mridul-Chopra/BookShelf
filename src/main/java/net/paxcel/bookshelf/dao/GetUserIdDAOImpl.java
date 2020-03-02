package net.paxcel.bookshelf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GetUserIdDAOImpl implements GetUserIdDAO {

	@Autowired QueryHelper sql;
	@Autowired Logger log;
	
	@Override
	public ResultSet getId(String username) throws Exception {
		
		String query = "Select USER_ID from USERS where username = ?";
		sql.setQuery = (Void)->
								{
									try 
									{
										sql.st.setString(1, username); //seting query
									} catch (SQLException e) 
									{
										log.error(e);
									}
									return Void;
								};
		ResultSet result = sql.getData(query); // executing query
		return result;
	}

}
