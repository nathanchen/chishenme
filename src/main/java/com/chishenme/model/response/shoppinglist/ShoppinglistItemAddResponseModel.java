package com.chishenme.model.response.shoppinglist;

public class ShoppinglistItemAddResponseModel
{
	public int code;
	
	public ShoppinglistItemAddResponseModel() {}
	
	public ShoppinglistItemAddResponseModel(int code)
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
