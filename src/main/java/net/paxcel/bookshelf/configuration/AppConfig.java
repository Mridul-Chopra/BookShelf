package net.paxcel.bookshelf.configuration;

import java.util.Properties;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import net.paxcel.bookshelf.dbUtils.Pool;

@Configuration
public class AppConfig {

	@Autowired
	Logger log;

	@Bean
	public Logger getLogger() {
		try {
			Logger log;

			log = Logger.getLogger("GLOBAL"); // getting logger

			Properties prop = new Properties();// contains logger properties

			Resource resource = new ClassPathResource("application.properties");
			prop = PropertiesLoaderUtils.loadProperties(resource); // loading the properties
			System.out.println("Done Loading Logger");
			PropertyConfigurator.configure(prop); // configuring properties
			log.setLevel(Level.INFO); // setting logging level

			return log;
		} catch (Exception e) {
			System.out.println("Cannot load resources. Exiting");
			System.exit(0); // Exiting on unsuccessful loading
		}

		return null;

	}

	@Bean
	public Pool getPool() {
		try {

			Pool pool = new Pool();
			pool.setMaxLimit(1); // setting max number of connections in pool
			pool.setMinLimit(1); // setting minimum number of connections in pool
			pool.setMaxWaitngProcesses(4); // setting waiting processes limit

			Properties connectionProp = new Properties(); // contains connection properties
			Resource resource = new ClassPathResource("application.properties");
			connectionProp = PropertiesLoaderUtils.loadProperties(resource); // loading the properties
			/* Getting DB url , username ,password , driver */
			String driver = connectionProp.getProperty("DB.Driver");
			String url = connectionProp.getProperty("DB.url");
			String username = connectionProp.getProperty("DB.username");
			String password = connectionProp.getProperty("DB.password");

			
			pool.setDriver_(driver);
			pool.setUrl_(url);
			pool.setPassword_(password);
			pool.setUsername_(username);
			
			pool.establishPool();
			System.out.println("Pool Creation Done");
			return pool;
		}

		catch (Exception ex) {
			log.error(ex); // logging the error
			System.out.println("Fatal Error. Abnormal Termination"); // Reporting to user
			System.exit(0); // exiting the system
		}
		return null;
	}
}
