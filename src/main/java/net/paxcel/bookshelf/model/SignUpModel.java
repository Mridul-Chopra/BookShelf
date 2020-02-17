package net.paxcel.bookshelf.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;


/*
Model class contains all sign up details
*/
@Component
public class SignUpModel implements java.io.Serializable {
	
	@NotEmpty
	@Email
	private String email;  
	
	
	@Size(min=5)
	private String password ;
	
	
	@NotEmpty
	private String address;
	
	
	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
