package net.paxcel.bookshelf.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/*
	Model class Contains all authors and genres details
*/
@Component
public class AuthorsAndGenresModel {

	List<String> authors = new ArrayList<String>();
	List<String> genres = new ArrayList<String>();
	
	/*
	 *  Getters an Setters
	*/
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public List<String> getGenres() {
		return genres;
	}
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	
}
