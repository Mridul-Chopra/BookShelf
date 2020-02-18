package net.paxcel.bookshelf.dao;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface OrderDAO {

	public int placeOrder(Map<String,Integer> books , String email);
}

