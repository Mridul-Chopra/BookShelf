package net.paxcel.bookshelf.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface GetAuthorsService {

	public List<String> getAuthors();  // function to get list of authors
}
