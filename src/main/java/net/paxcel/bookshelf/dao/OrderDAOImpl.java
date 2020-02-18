/*
 * package net.paxcel.bookshelf.dao;
 * 
 * import java.sql.SQLException; import java.text.DateFormat; import
 * java.text.SimpleDateFormat; import java.util.ArrayList; import
 * java.util.Date; import java.util.Map;
 * 
 * import org.apache.log4j.Logger; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * @Service public class OrderDAOImpl implements OrderDAO{
 * 
 * @Autowired QueryHelper sql;
 * 
 * @Autowired Logger log;
 * 
 * @Override public int placeOrder(Map<String, Integer> books , String email) {
 * 
 * log.info("Welcome to DAO"); DateFormat dateFormat = new
 * SimpleDateFormat("dd/MM/yy"); Date date = new Date();
 * 
 * String query =
 * "Insert into ORDERS(CUSTOMER_ID,BOOK_NAME,AMOUNT,DATE_OF_ORDER) values";
 * 
 * for(int i=1;i<=books.size()-1;i++) { query+="(? , ? , ? , ?) , "; }
 * 
 * query+="(?,?,?,?) ;";
 * 
 * 
 * 
 * ArrayList<String> bookslist = new ArrayList<String>(books.keySet());
 * ArrayList<Integer> quantity = new ArrayList<Integer>(books.values());
 * 
 * sql.setQuery= (Void)-> { for(int i=1;i<=books.size();i++) { try {
 * sql.st.setString((4*i-3),email);
 * sql.st.setString((4*i-2),bookslist.get(i-1));
 * sql.st.setInt((4*i-1),quantity.get(i-1));
 * sql.st.setString(4*i,dateFormat.format(date)); }
 * 
 * catch (SQLException e) { log.error(this.getClass()+"-->>"+e); } }
 * 
 * return Void; };
 * 
 * int status = sql.setData(query); return status;
 * 
 * }
 * 
 * }
 */