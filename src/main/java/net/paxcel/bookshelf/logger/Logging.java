package net.paxcel.bookshelf.logger;


import org.apache.log4j.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import java.util.Properties;

@Deprecated
public class Logging {
	
	
	public  Logger log_;					// logger object 
	public String className = "DEFAULT";
	public void setLogger()
	{
		
			try
			{
			
			
			log_ = Logger.getLogger(className);  		// getting logger
			
			Properties prop = new Properties();// contains logger properties
			
			Resource resource = new ClassPathResource("application.properties");
			prop = PropertiesLoaderUtils.loadProperties(resource); //loading the properties
			System.out.println("Done 1");
			PropertyConfigurator.configure(prop);  // configuring properties
			log_.setLevel(Level.ERROR);				// setting logging level
			
			}
			catch(Exception e)
			{
				System.out.println("Cannot load resources. Exiting");  
				System.exit(0);		// Exiting on unsuccessful loading
			}
			
		}
		
	

}
