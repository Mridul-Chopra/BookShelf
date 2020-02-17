package net.paxcel.bookshelf.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/*
Model class contains all books details for showing purpose
*/
@Component
public class BooksModel {
	
	private String bookName;
	private String genre;
	private int stock;
	private float price;
	List<String> authors = new ArrayList<String>();
	
	/*
		Getters and Setters
	*/
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public void addAuthor(String author)
	{
		authors.add(author);
	}

	

}
