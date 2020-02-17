package net.paxcel.bookshelf.model;

import org.springframework.stereotype.Component;

/*
Model class contains all books purchase details 
*/
@Component
public class BooksPurchaseModel {

	String bookName;
	int amount;
	String date;
	
	/*
	 *  Getters an Setters
	*/
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
