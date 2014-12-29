package com.chishenme.config;

public enum RtnCodeReference
{
	// createUser
	USER_CREATEUSER_REQUEST_FINISHED_SUCCESSFULLY(0),
	USER_CREATEUSER_PASSWORD_MISMATCH(1),
	USER_CREATEUSER_INVALID_NAME_FORMAT(2),
	USER_CREATEUSER_INVALID_PASSWORD_FORMAT(3),
	USER_CREATEUSER_DUPLICATE_USER(4),
	USER_CREATEUSER_NAME_IS_NULL_OR_EMPTY(5),
	USER_CREATEUSER_PASSWORD_IS_NULL_OR_EMPTY(6),
	USER_CREATEUSER_CONFIRM_PASSWORD_IS_NULL_OR_EMPTY(7),
	USER_CREATEUSER_CHECKSUM_IS_NULL_OR_EMPTY(8),
	USER_CREATEUSER_CHECKSUM_FAIL(9),
	
	
	// LOGIN
	USER_LOGIN_REQUEST_FINISHED_SUCCESSFULLY(0),
	USER_LOGIN_NAME_IS_NULL_OR_EMPTY(1),
	USER_LOGIN_PASSWORD_IS_NULL_OR_EMPTY(2),
	USER_LOGIN_PASSWORD_DOESNT_MATCH(3),
	USER_LOGIN_INVALID_ACCOUNT(4),
	USER_LOGIN_CHECKSUM_FAIL(5),
	USER_LOGIN_CHECKSUM_IS_NULL_OR_EMPTY(6),
	
	// requestToAddFriend
	FRIEND_REQUESTTOADDFRIEND_REQUEST_FINISHED_SUCCESSFULLY(0),
	FRIEND_REQUESTTOADDFRIEND_INVALID_USERID(1),
	FRIEND_REQUESTTOADDFRIEND_INVALID_FRIENDID(2),
	FRIEND_REQUESTTOADDFRIEND_ARE_ALREADY_FRIENDS(3),
	FRIEND_REQUESTTOADDFRIEND_FRIEND_REQUEST_STILL_PENDING(4),
	FRIEND_REQUESTTOADDFRIEND_USER_IS_BLACKLISTED(5),
	FRIEND_REQUESTTOADDFRIEND_BECOME_FRIENDS(6),
	FRIEND_REQUESTTOADDFRIEND_CANNOT_FRIEND_SELF(7);	
	
	private int rtnCode;
	
	RtnCodeReference(int rtnCode)
	{
		this.rtnCode = rtnCode;
	}
	
	public int getRtnCode()
	{
		return this.rtnCode;
	}
}
