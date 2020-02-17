package net.paxcel.bookshelf.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.paxcel.bookshelf.model.BooksModel;

@Service
public interface GetAdminInfoService {

	public List<?> getBooks(int option); // get books asked by admin
}
