package net.paxcel.bookshelf.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCrypt;
//@Component
public class Hasher {
	
	
	public static String getHash(String passwordToHash)
	{
        
		String generatedPassword = null;
		BCrypt hash = new BCrypt();
		String salt = hash.gensalt();
		generatedPassword = hash.hashpw(passwordToHash , salt);
		return generatedPassword;
    }
	
}

