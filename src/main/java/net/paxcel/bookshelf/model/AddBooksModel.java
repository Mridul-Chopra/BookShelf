
package net.paxcel.bookshelf.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.sun.istack.internal.NotNull;

@Component
/*
	Model class contains all books details for adding purpose
*/
public class AddBooksModel {

	@Size(min=1,max=50)private String bookName;
	@Size(min=1,max=30) private String genre;
	@NotNull @Min(value=1) private Float price;
	@Size(min=1,max=30) private List<String> authors;
	@NotEmpty private String date;
	@NotNull @Min(value=1)private Integer amount;
	
	
	/*
	 *  Getters an Setters
	*/
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;    
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
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

	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	
}
