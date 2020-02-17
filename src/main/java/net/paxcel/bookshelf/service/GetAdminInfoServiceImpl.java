package net.paxcel.bookshelf.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.paxcel.bookshelf.dao.RetrieveAdminInfoDAO;
import net.paxcel.bookshelf.model.BooksModel;
import net.paxcel.bookshelf.model.BooksPurchaseModel;
import net.paxcel.bookshelf.model.OrdersModel;

@Service
public class GetAdminInfoServiceImpl implements GetAdminInfoService {

	@Autowired
	RetrieveAdminInfoDAO booksData;

	@Autowired 
	Logger log;

	@Override
	public List<?> getBooks(int option) {

		
		// getting books based upon option given
		switch(option)
		{

			case 1:
			{
					List<BooksModel>books=new ArrayList<BooksModel>(); // list of books
					BooksModel book; // model to store book info
					
					ResultSet rs =booksData.retrieveBooks(option); // getting books
					try 
					{
						while(rs.next())
						{
							
							/*
							 *  retrieving books info
							*/
		
							String bookName = rs.getString("BOOK_NAME");
							int stock = rs.getInt("STOCK");
							String genre = rs.getString("GENRE");
							float price = rs.getFloat("PRICE");
		
							book = new BooksModel();
		
							book.setBookName(bookName);
							book.setStock(stock);
							book.setGenre(genre);
							book.setPrice(price);
		
							books.add(book);
						}
						
						return books; // returning data
					}
					catch(Exception e)
					{
						log.error(this.getClass()+"--->"+e);
					}
			}
			
			case 2:
			{
				List<BooksPurchaseModel> booksPurchase = new ArrayList<BooksPurchaseModel>(); // list of books orders
				BooksPurchaseModel purchase; // model to store book info
				ResultSet rs =booksData.retrieveBooks(option); // getting books
				try 
				{
					while(rs.next())
					{
						/*
						 *  retrieving books purchase info
						*/
	
						String bookName = rs.getString("BOOK_NAME");
						int amount = rs.getInt("amount");
						String date = rs.getDate("DATE_OF_PURCHASE").toString();;
						
						purchase = new BooksPurchaseModel();
						
						purchase.setBookName(bookName);
						purchase.setAmount(amount);
						purchase.setDate(date);
						
						booksPurchase.add(purchase);
					}
					return booksPurchase; // returning data
				}
				catch(Exception e)
				{
					log.error(this.getClass()+"--->"+e);
				}
			}
			
			case 3:
			{
				List<OrdersModel> orders = new ArrayList<OrdersModel>(); // list of orders
				OrdersModel order; // model to store book info
				ResultSet rs =booksData.retrieveBooks(option); // getting books
				try 
				{
					while(rs.next())
					{
						/*
						 *  retrieving books orders  info
						*/
				
						int orderID = rs.getInt("ORDER_ID");
						String email = rs.getString("CUSTOMER_ID");
						String bookName = rs.getString("BOOK_NAME");
						int amount = rs.getInt("AMOUNT");
						String date = rs.getDate("DATE_OF_ORDER").toString();
						
						order = new OrdersModel();
						
						order.setOrderID(orderID);
						order.setEmail(email);
						order.setBookName(bookName);
						order.setAmount(amount);
						order.setDate(date);
						
						orders.add(order);
					}
					return orders; // returning data
				}
				catch(Exception e)
				{
					log.error(this.getClass()+"--->"+e);
				}
			}
		}
		return null;
	}

}
