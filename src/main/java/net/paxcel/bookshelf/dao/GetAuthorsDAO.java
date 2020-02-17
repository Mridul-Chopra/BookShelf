package net.paxcel.bookshelf.dao;

import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

@Repository
/*
 *	Interface to get all authors from data base 
 */
public interface GetAuthorsDAO {

	public ResultSet getAuthors() throws Exception;
}
