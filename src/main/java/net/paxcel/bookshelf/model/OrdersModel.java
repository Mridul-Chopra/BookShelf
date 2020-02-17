package net.paxcel.bookshelf.model;

import org.springframework.stereotype.Component;


/*
Model class contains all orders details 
*/
@Component
public class OrdersModel {
	
	int orderID;
	String email;
	String bookName;
	int amount;
	String date;
	
	
	/*
	 *  Getters an Setters
	*/
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
