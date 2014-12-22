package com.chishenme.model.response.user;

import com.chishenme.model.user.UserInfo;

public class UserAddResponseModel
{
	private String code;
	private UserInfo userInfo;
	
	public UserAddResponseModel() {}
	
	public UserAddResponseModel(String code, UserInfo userInfo)
	{
		this.code = code;
		this.userInfo = userInfo;
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
