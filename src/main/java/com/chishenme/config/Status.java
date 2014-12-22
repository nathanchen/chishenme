package com.chishenme.config;

public enum Status
{
	USER_STATUS_NORMAL (0),
	USER_STATUS_CANCELLED (1),
	USER_STATUS_DISABLED (2),
	USER_STATUS_PENDINGG (3);
	
	
	
	
	
	private int statusCode;

	Status(int statusCode)
	{
		this.statusCode = statusCode;
	}
	
	public int getStatusCode()
	{
		return this.statusCode;
	}
}
