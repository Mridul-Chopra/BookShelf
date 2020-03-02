package net.paxcel.bookshelf.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.paxcel.bookshelf.utils.Hasher;


/*
Model class contains login info
*/
@Component
public class LoginModel implements java.io.Serializable{
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	private String password;
	
	@Autowired Logger log;
	private String hashedPassword;
	
	
	//@Autowired private Hasher hash;
	
	/*
	 *  Getters an Setters
	*/
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) {
		try 
		{
		hashedPassword =Hasher.getHash(password);
		this.password=hashedPassword;
		log.info(password);
		}
		catch(Exception e)
		{
			log.error(e);
		}
		this.password = password;
	}
	
	
	
}
