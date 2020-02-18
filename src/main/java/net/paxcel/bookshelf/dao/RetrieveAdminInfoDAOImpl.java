/*
 * package net.paxcel.bookshelf.dao;
 * 
 * import java.sql.ResultSet; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Repository;
 * 
 * @Repository public class RetrieveAdminInfoDAOImpl implements
 * RetrieveAdminInfoDAO {
 * 
 * @Autowired QueryHelper sql;
 * 
 * @Override public ResultSet retrieveBooks(int option) {
 * 
 * ResultSet result ; String query = "";
 * 
 * 
 * setting query based on option
 * 
 * switch(option) { case 1: { query = "Select * from BOOKS"; break; } case 2: {
 * query = "Select * from BOOKS_PURCHASES"; break; } case 3: { query =
 * "Select * from ORDERS "; break; } }
 * 
 * // setting query sql.setQuery=(Void)-> { return Void; };
 * 
 * result = sql.getData(query); // gtting data return result; //returning result
 * }
 * 
 * }
 */