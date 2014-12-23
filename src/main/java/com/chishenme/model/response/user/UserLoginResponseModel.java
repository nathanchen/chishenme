package com.chishenme.model.response.user;

public class UserLoginResponseModel
{
	private int code;
	private int user_id;
	private String userName;
	
	public UserLoginResponseModel() {}
	
	public UserLoginResponseModel(int code, int user_id, String userName)
	{
		this.code = code;
		this.user_id = user_id;
		this.userName = userName;
	}
	
	public int getCode()
	{
		return code;
	}
	public void setCode(int code)
	{
		this.code = code;
	}
	public int getUser_id()
	{
		return user_id;
	}
	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	
}
