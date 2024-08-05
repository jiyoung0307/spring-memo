package com.toy.proj.common;

import java.util.Random;

public interface CommonUtil {
	
	public static String getSaltString() {
		String SALTCHARS = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        
        while (salt.length() < 7) { // length of the random string.
        	
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        
        return salt.toString();
	}

}