package net.paxcel.bookshelf.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface GetGenresService {

	public List<String> getGenres() ; // function to get all genres
}
