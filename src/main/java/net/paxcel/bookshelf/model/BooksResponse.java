package net.paxcel.bookshelf.model;

import java.util.List;



public class BooksResponse {

	int totalPages;
	List<BooksModel> booksList;
	
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int total) {
		this.totalPages = total;
	}
	public List<BooksModel> getBooksList() {
		return booksList;
	}
	public void setBooksList(List<BooksModel> booksList) {
		this.booksList = booksList;
	}
	
}
