package com.wmc.component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component
public class HashComponent {
	public String getHash(String input) {
		String output;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-512");
			}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(input.getBytes());
		output = String.format("%0128x", new BigInteger(1,md.digest()));
		return output;
	}

}
