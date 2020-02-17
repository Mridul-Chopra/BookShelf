package net.paxcel.bookshelf.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;


/*
Model class contains login info
*/
@Component
public class LoginModel implements java.io.Serializable{
	
	@NotEmpty
	@Email
	String email;
	
	@NotEmpty
	String password;
	
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
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
