package com.chishenme.model.response.shoppinglist;

public class ShoppinglistAddResponseModel
{
	int code;
	
	public ShoppinglistAddResponseModel() {}
	
	public ShoppinglistAddResponseModel(int code)
	{
		this.code = code;
	}

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}
}
