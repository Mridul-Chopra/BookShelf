package net.paxcel.bookshelf.dao;

import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

@Repository
public interface LoginDAO {

	public ResultSet checkLogin(String email , String password) throws Exception; // function to check login of user
}
