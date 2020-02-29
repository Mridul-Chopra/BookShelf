package net.paxcel.bookshelf.dao;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface OrderDAO {

	public boolean placeOrder(Map<Integer,Integer> books , int id);
}

