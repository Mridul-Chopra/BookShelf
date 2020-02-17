
package net.paxcel.bookshelf.model;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
/*
	Model class contains all books details for adding purpose
*/
public class AddBooksModel {

	@NotEmpty private String bookName;
	@NotEmpty private String genre;
	@Min(value=1)private float price;
	@NotEmpty private List<String> authors;
	@NotEmpty private String date;
	@Min(value=1)  private int amount;
	
	
	/*
	 *  Getters an Setters
	*/
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public List<String> getAuthor() {
		return authors;
	}
	public void setAuthor(List<String> authors) {
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

	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
