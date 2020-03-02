package net.paxcel.bookshelf.service;


import org.springframework.stereotype.Service;

import net.paxcel.bookshelf.model.BooksResponse;

@Service
public interface GetBooksService {
	
	public BooksResponse getBooks(String data ) ; // get books with filters
	public BooksResponse getBooksbyName(String bookName);
}
