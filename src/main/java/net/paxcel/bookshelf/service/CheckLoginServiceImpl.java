package net.paxcel.bookshelf.service;

import java.sql.ResultSet;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import net.paxcel.bookshelf.dao.LoginDAO;

@Service
public class CheckLoginServiceImpl implements CheckLoginService,org.springframework.security.core.userdetails.UserDetailsService{

	//@Autowired
	//LoginDAO login;  // get login dao
	
	@Autowired
	Logger log; // getting logger
	
	@Override
	public int checkLogin(String email , String password) throws Exception
	{
		try
		{
			
	//		ResultSet rs = login.checkLogin(email,password); // get results from dao
			
			/*
			 * if(rs.next()) {
			 * 
			 * if(rs.getBoolean("IS_ADMIN")) { return 2; // if admin return 2 } else {
			 * return 1; // normal user return 1 } } else
			 */	{
				return 0; // invlid info return 0
			}
				
			
		}
		catch(Exception e)
		{
			log.error(this.getClass()+"--->"+e); 
			throw new Exception();
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
