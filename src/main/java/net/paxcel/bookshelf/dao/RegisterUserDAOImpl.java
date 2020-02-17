package net.paxcel.bookshelf.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterUserDAOImpl implements RegisterUserDAO {
	
	@Autowired
	Logger log;  // getting logger
	
	@Autowired
	QueryHelper sql_; // getting custom query helper

	@Override
	public Integer enterUserData(String email, String password ,String address)  {
	
	String sql = "Insert into users values (? , ? , ?, ?)"; // creating query to insert
	
	// setting parameters
	sql_.setQuery = (Void) ->
	{	
		try {
			
			sql_.st.setString(1,email);
			sql_.st.setString(2,password);
			sql_.st.setInt(3,1);
			sql_.st.setString(4,address);
		}
		catch(Exception e)
		{
			log.error(this.getClass()+"--->"+e);
		}
		return Void;
	};
	
	// inserting data and returning results
	int status = sql_.setData(sql);
	if(status !=1)
		return status;
	
	sql = "Insert into user_roles(username , role) values (? , ? )";
	sql_.setQuery = (Void) ->
	{	
		try
		{
			
			sql_.st.setString(1,email);
			sql_.st.setString(2,"ROLE_USER");
		}
		catch(Exception e)
		{
			log.error(this.getClass()+"--->"+e);
		}
		return Void;
	};
	
	status = sql_.setData(sql);
	if(status !=1)
		return status;
	
	return 1;
		
	}

}
