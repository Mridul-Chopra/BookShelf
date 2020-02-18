package net.paxcel.bookshelf.service;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.paxcel.bookshelf.dao.OrderDAO;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired OrderDAO order;
	@Autowired Logger log;
	
	@Override
	public int addOrder(String books , String email) {
		JSONObject data = new JSONObject(books);
		HashMap<String, Integer> booksmap = new HashMap<>();
		Iterator<String> iter =data.keys();
		while (iter.hasNext()) {
		   String key = iter.next();
		   booksmap.put(key, Integer.parseInt((String) data.get(key)));
		}
		return order.placeOrder(booksmap , email);
	}

}
