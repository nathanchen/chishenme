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
	FRIEND_REQUESTTOADDFRIEND_CANNOT_FRIEND_SELF(7),
	FRIEND_REQUESTTOADDFRIEND_CHECKSUM_IS_NULL_OR_EMPTY(8),
	FRIEND_REQUESTTOADDFRIEND_CHECKSUM_FAIL(9),
	
	// CHECK FRIEND REQUEST RESPONSE
	CHECK_FRIEND_REQUEST_SUCCESSFULLY(0),
	CHECK_FRIEND_REQUEST_USERID_IS_NULL_OR_EMPTY(1),
	CHECK_FRIEND_REQUEST_CHECKSUM_IS_NULL_OR_EMPTY(2),
	CHECK_FRIEND_REQUEST_INVALID_USERID(3),
	CHECK_FRIEND_REQUEST_CHECKSUM_FAIL(4),
	
	// FRIEND REQUEST STATUS
	FRIEND_REQUEST_BECOME_FRIENDS(0),
	FRIEND_REQUEST_WAITING_FOR_RESPONSE(1),
	FRIEND_REQUEST_DECLINED(2),
	
	// USER ACCOUNT STATUS
	USER_ACCOUNT_NOT_VARIFIED(0),
	USER_ACCOUNT_VARIFIED(1),
	USER_ACCOUNT_PENDING(2),
	USER_ACCOUNT_INVALID(3),
	
	// requestToAddShoppinglistItem
	SHOPPINGLIST_REQUESTTOADDSHOPPINGLISTITEM_REQUEST_FINISHED_SUCCESSFULLY(0),
	SHOPPINGLIST_REQUESTTOADDSHOPPINGLISTITEM_INVALID_CREATORID(1),
	SHOPPINGLIST_REQUESTTOADDSHOPPINGLISTITEM_INVALID_SUBJECT(2),
	SHOPPINGLIST_REQUESTTOADDSHOPPINGLISTITEM_INVALID_QUANTITY(3),
	SHOPPINGLIST_REQUESTTOADDSHOPPINGLISTITEM_INVALID_UNIT(4),
	SHOPPINGLIST_REQUESTTOADDSHOPPINGLISTITEM_CHECKSUM_IS_NULL_OR_EMPTY(5),
	SHOPPINGLIST_REQUESTTOADDSHOPPINGLISTITEM_CHECKSUM_FAIL(6),
	SHOPPINGLIST_REQUESTTOADDSHOPPINGLISTITEM_INVALID_SHOPPINGLISTID(7),
	
	// SHOPPINGLIST ITEM STATUS
	SHOPPINGLIST_ITEM_ENABLED(0),
	SHOPPINGLIST_ITEM_CHECKED(1),
	SHOPPINGLIST_ITEM_DISABLED(2),
	SHOPPINGLIST_ITEM_PENDING(3),
	
	// requestToAddShoppinglist
	SHOPPINGLIST_REQUESTTOADDSHOPPINGLIST_REQUEST_FINISHED_SUCCESSFULLY(0),
	SHOPPINGLIST_REQUESTTOADDSHOPPINGLIST_INVALID_CREATORID(1),
	SHOPPINGLIST_REQUESTTOADDSHOPPINGLIST_INVALID_SUBJECT(2),
	SHOPPINGLIST_REQUESTTOADDSHOPPINGLIST_CHECKSUM_IS_NULL_OR_EMPTY(3),
	SHOPPINGLIST_REQUESTTOADDSHOPPINGLIST_CHECKSUM_FAIL(4),
	
	// SHOPPINGLIST STATUS
	SHOPPINGLIST_ENABLED(0),
	SHOPPINGLIST_CHECKED(1),
	SHOPPINGLIST_DELETED(2),
	SHOPPINGLIST_PENDING(3);
	
	
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
