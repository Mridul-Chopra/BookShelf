package net.paxcel.bookshelf.service;

import org.springframework.stereotype.Service;

@Service
public interface OrderService {

public int addOrder(String books , String email) ;
	
}
