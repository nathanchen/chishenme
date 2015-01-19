package com.chishenme.model.response.shoppinglist;

import java.util.ArrayList;

import com.chishenme.model.shoppinglist.ShoppinglistItem;

public class ShoppinglistItemsResponseModel
{
	ArrayList<ShoppinglistItem> shoppinglistItems;
	int code;
	
	public ShoppinglistItemsResponseModel() {}
	
	public ShoppinglistItemsResponseModel(int code, ArrayList<ShoppinglistItem> shoppinglistItems)
	{
		this.code = code;
		this.shoppinglistItems = shoppinglistItems;
	}

	public ArrayList<ShoppinglistItem> getShoppinglistItems()
	{
		return shoppinglistItems;
	}

	public void setShoppinglistItems(ArrayList<ShoppinglistItem> shoppinglistItems)
	{
		this.shoppinglistItems = shoppinglistItems;
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
