package com.chishenme.config;

public enum StatusReference
{
	// user account status
	USER_STATUS_NORMAL (0),
	USER_STATUS_CANCELLED (1),
	USER_STATUS_DISABLED (2),
	USER_STATUS_PENDINGG (3),
	
	
	// user login info status
	USER_LOGIN_INFO_STATUS_NORMAL(0),
	USER_LOGIN_INFO_STATUS_CANCELLED(1),
	USER_LOGIN_INFO_STATUS_DISABLED(2),
	USER_LOGIN_INFO_STATUS_PENDING(3),
	USER_LOGIN_INFO_STATUS_EXPIRED(4),
	
	
	// user partner status
	USER_PARTNER_STATUS_FRIEND(0),
	USER_PARTNER_STATUS_WAITINGFORREPLY(1),
	USER_PARTNER_STATUS_DECLIED(2),
	
	// friend black list info status
	FRIEND_BLACK_LIST_INFO_STATUS_NORMAL(0),
	FRIEND_BLACK_LIST_INFO_STATUS_CANCELLED(1),
	FRIEND_BLACK_LIST_INFO_STATUS_DISABLED(2);
	
	
	private int statusCode;

	StatusReference(int statusCode)
	{
		this.statusCode = statusCode;
	}
	
	public int getStatusCode()
	{
		return this.statusCode;
	}
}
