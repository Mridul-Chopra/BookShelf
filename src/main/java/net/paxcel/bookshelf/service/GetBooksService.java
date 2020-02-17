package net.paxcel.bookshelf.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.paxcel.bookshelf.model.BooksModel;

@Service
public interface GetBooksService {
	
	public List<BooksModel> getBooks(String author , String genre) ; // get books with filters

}
