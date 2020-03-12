package net.paxcel.bookshelf.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.paxcel.bookshelf.utils.Hasher;


/*
Model class contains all sign up details
*/
@Component
public class SignUpModel implements java.io.Serializable {
	
	@NotEmpty
	@Email
	private String email;  
	
	
	@Size(min=5,max=30)
	private String password ;
	
	
	@Size(min=3,max=30)
	private String address;
	
	@Autowired private Logger log;
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

	public String getPassword() {
		return hashedPassword;
	}

	public void setPassword(String password) {
		try 
		{
		hashedPassword =Hasher.getHash(password);
		this.password=password;
		}
		catch(Exception e)
		{
			log.error(e);
		}
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
