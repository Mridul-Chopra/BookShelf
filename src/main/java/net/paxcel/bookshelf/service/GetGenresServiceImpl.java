package net.paxcel.bookshelf.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.paxcel.bookshelf.dao.GetGenresDAO;

@Service
public class GetGenresServiceImpl implements GetGenresService{

	@Autowired Logger log;
	@Autowired GetGenresDAO genres; // dao class to get genres
	
	@Override
	public List<String> getGenres() {
		
		List<String> genresList = new ArrayList<String>();
		ResultSet result;
		try 
		{
			result = genres.getGenres();  // getting all genres
		}
		catch(Exception e)
		{
			return null;
		}
		
		try
		{
			while(result.next())
			{
				String genre = result.getString("GENRE"); // getting genre
				genresList.add(genre); // putting all genres in list
			}
			
			return genresList;
		}
		catch(Exception e)
		{
			log.error(this.getClass()+"-->> "+e);
			return null;
		}
		
	}
	
	

}
