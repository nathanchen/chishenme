package com.chishenme.util;

public class Users
{
	/**
	 * 
	 * a valid user id should match the following criteria: 
	 * 1. is an integer
	 *
	 * 
	 * @param candidate
	 * @return
	 */
	public static boolean isValidUserId(String candidate)
	{
		return Strings.isInteger(candidate);
	}
}
