package com.chishenme.model.response.user;

import com.chishenme.model.user.UserInfo;

public class UserAddResponseModel
{
	private String code;
	private String userName;
	private UserInfo userInfo;
	
	public UserAddResponseModel() {}
	
	public UserAddResponseModel(String code, String userName, UserInfo userInfo)
	{
		this.code = code;
		this.userName = userName;
		this.userInfo = userInfo;
	}
	
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getCode()
	{
		return code;
	}
	public void setCode(String code)
	{
		this.code = code;
	}
	public UserInfo getUserInfo()
	{
		return userInfo;
	}
	public void setUser(UserInfo userInfo)
	{
		this.userInfo = userInfo;
	}
}
