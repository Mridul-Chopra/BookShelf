package net.paxcel.bookshelf.dao;

import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

@Repository
public interface GetUserIdDAO {

	public ResultSet getId(String username) throws Exception;
}
