package net.paxcel.bookshelf.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.paxcel.bookshelf.dao.GetAuthorsDAO;

@Service
public class GetAuthorsServiceImpl implements GetAuthorsService {

	@Autowired GetAuthorsDAO authors;  // dao interface to get authors
	@Autowired Logger log;
	
	@Override
	public List<String> getAuthors() {
		
		ResultSet result;
		List<String> authorsList = new ArrayList<String>();
		
		try
		{
			result = authors.getAuthors(); // getting all authors
		}
		catch(Exception e)
		{
			return null; // return null on error
		}
		
		try 
		{
			while(result.next())
			{
				String authorName = result.getString("AUTHOR_NAME"); // getting author names
				authorsList.add(authorName); // adding to list
			}
			
			return authorsList;
		}
		catch(Exception e)
		{
			log.error(e);
			return null;
		}
		
	}

}
