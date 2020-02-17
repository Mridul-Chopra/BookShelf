package net.paxcel.bookshelf.dao;

import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

@Repository
public interface RegisterUserDAO {
	
	// function to sign up new user
	public Integer enterUserData(String email , String password  , String address);

}
