package net.paxcel.bookshelf.dao;

import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

@Repository
/*
 *  class to get all genres
 */
public interface GetGenresDAO {

	public ResultSet getGenres() throws Exception; // function to get all genres
}
