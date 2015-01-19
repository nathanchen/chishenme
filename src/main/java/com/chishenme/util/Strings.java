package com.chishenme.util;

public class Strings
{
	public static boolean isInteger(String candidateString)
	{
		try
		{
			Integer.parseInt(candidateString);
		}
		catch (NumberFormatException e)
		{
			return false;
		}
		return true;
	}
	
	public static boolean isNullOrEmpty(String candidateString)
	{
		if (candidateString == null || "".equals(candidateString))
		{
			return true;
		}
		return false;
	}
}
