package net.paxcel.bookshelf.service;

import java.sql.ResultSet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.paxcel.bookshelf.dao.GetUserIdDAO;

@Service
public class GetUserIdServiceImpl implements GetUserIdService
{

	@Autowired GetUserIdDAO user;
	@Autowired Logger log;
	
	@Override
	public int getId(String username) throws Exception {
		
		try
		{
			ResultSet result = user.getId(username);
		
			if(result.next())
			{
				int id = result.getInt("USER_ID");
				return id;
			}
			else
			{
				return -1;
			}
		}
		catch(Exception e)
		{
			log.error(e);
		}
		return 0;
	}

}
