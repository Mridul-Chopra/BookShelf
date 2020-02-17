package net.paxcel.bookshelf.service;

import org.springframework.stereotype.Service;

@Service
public interface CheckLoginService {

	// function to check login
	public int checkLogin(String email , String password) throws Exception;
}
