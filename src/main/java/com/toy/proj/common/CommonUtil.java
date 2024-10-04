package com.toy.proj.common;

import java.util.Random;

public interface CommonUtil {
	
	public static String getSaltString(int x) {
		String SALTCHARS = "1234567890abcdefghijklmnopqrstuvwxyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        
        while (salt.length() < x) { // length of the random string.
        	
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        
        return salt.toString();
	}

    public static String getSaltString() {
        return getSaltString(7);
    }

}