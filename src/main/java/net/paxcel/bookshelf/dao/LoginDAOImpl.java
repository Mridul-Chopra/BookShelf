package net.paxcel.bookshelf.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired Logger log;
	@Autowired QueryHelper sql_;
	 
	@Override
	public ResultSet checkLogin(String email, String password) throws Exception {

		
		
		  String sql = "Select * from CUSTOMERS where EMAIL = ? and LOGIN_PASSWORD = ? ";  // query to check login
		  ResultSet result;
	
		  // setting login
		  sql_.setQuery = (Void)-> {
		  
		  try {
		  
		  sql_.st.setString(1, email); 
		  sql_.st.setString(2, password);
		  
		  }
		  
		  catch (SQLException e) 
		  { log.error(this.getClass()+"--->"+e); } // logging exception
		  
		  return Void;
		  
		  };
		  
		  result = sql_.getData(sql);  // getting results from data base
		 
		  if (result==null)
		  {
			  throw new Exception(); // throw a new exception if error occurs
		  }
		  return result;

	}

}
