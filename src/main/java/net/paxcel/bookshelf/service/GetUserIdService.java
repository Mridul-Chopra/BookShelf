package net.paxcel.bookshelf.service;

import org.springframework.stereotype.Service;

@Service
public interface GetUserIdService {

	public int getId(String username) throws Exception; // service method to get id
}
