package com.chishenme.config;

public enum Status
{
	// user account status
	USER_STATUS_NORMAL (0),
	USER_STATUS_CANCELLED (1),
	USER_STATUS_DISABLED (2),
	USER_STATUS_PENDINGG (3),
	
	
	// user login info status
	USER_LOGIN_INFO_STATUS_NORMAL(0),
	USER_LOGIN_INFO_STATUS_EXPIRED(1),
	USER_LOGIN_INFO_STATUS_DISABLED(2);
	
	
	
	
	
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
