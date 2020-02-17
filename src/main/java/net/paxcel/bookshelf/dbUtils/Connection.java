package net.paxcel.bookshelf.dbUtils;


import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;



@Configuration
@Deprecated
public class Connection {
	
	
	java.sql.Connection cn;
	Properties connectionProp;
	
	@Autowired
	 Logger log ;
	
	@Bean
	public java.sql.Connection myConnection()
	{
		try
		{
			
			connectionProp = new Properties();     // contains connection properties
			
			Resource resource = new ClassPathResource("application.properties");
			connectionProp = PropertiesLoaderUtils.loadProperties(resource); //loading the properties
			
			
		
			
			 /* Getting DB url , username ,password , driver */
			
			String driver = connectionProp.getProperty("DB.Driver") ;
			String url = connectionProp.getProperty("DB.url");
			String username = connectionProp.getProperty("DB.username");
			String password = connectionProp.getProperty("DB.password");
			
			Class.forName(driver);	
			
			cn = DriverManager.getConnection(url,username,password); // establishing connection 
		
			
		}
		catch(Exception e)
		{
			log.error(e);									// logging the error
			System.out.println("Fatal Error. Exiting");     // Reporting to user
			System.exit(0);									// exiting the system
		}
		
		return cn;
	}

}
