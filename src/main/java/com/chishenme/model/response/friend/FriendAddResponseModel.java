package com.chishenme.model.response.friend;

public class FriendAddResponseModel
{
	private String code;
	
	public FriendAddResponseModel() {}
	
	public FriendAddResponseModel(String code)
	{
		this.code = code;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}
}
