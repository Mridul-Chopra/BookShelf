package net.paxcel.bookshelf.service;

import org.springframework.stereotype.Service;

@Service
public interface SignUpService {

	// function to sign up user
	public String signup(String email , String password  ,String address) ;
}
