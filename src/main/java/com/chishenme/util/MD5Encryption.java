package com.chishenme.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encryption
{
	public static String encrypt(String input)
	{
		String hashTextString = "";
		try
		{
			MessageDigest mDigest = MessageDigest.getInstance("MD5");
			byte[] messageDigest = mDigest.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			hashTextString = number.toString(16);
			while (hashTextString.length() < 32)
			{
				hashTextString = "0" + hashTextString;
			}
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		
		return hashTextString;
	}
}
