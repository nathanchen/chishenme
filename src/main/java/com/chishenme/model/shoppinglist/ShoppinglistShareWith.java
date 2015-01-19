package com.chishenme.model.shoppinglist;

import java.sql.Timestamp;

import com.chishenme.config.ModifierCodeReference;

public class ShoppinglistShareWith
{
	private int shoppinglist_id;
	private int creator_id;
	private int friend_id;
	private int shoppinglist_share_with_status;
	private Timestamp modify_date;
	private int modifier_code;
	
	public ShoppinglistShareWith()
	{
		
	}
	
	public ShoppinglistShareWith(int shoppinglist_id, int creator_id,
			int friend_id, int shoppinglist_share_with_status)
	{
		super();
		this.shoppinglist_id = shoppinglist_id;
		this.creator_id = creator_id;
		this.friend_id = friend_id;
		this.shoppinglist_share_with_status = shoppinglist_share_with_status;
	}

	public int getShoppinglist_id()
	{
		return shoppinglist_id;
	}
	public void setShoppinglist_id(int shoppinglist_id)
	{
		this.shoppinglist_id = shoppinglist_id;
	}
	public int getCreator_id()
	{
		return creator_id;
	}
	public void setCreator_id(int creator_id)
	{
		this.creator_id = creator_id;
	}
	public int getFriend_id()
	{
		return friend_id;
	}
	public void setFriend_id(int friend_id)
	{
		this.friend_id = friend_id;
	}
	public int getShoppinglist_share_with_status()
	{
		return shoppinglist_share_with_status;
	}
	public void setShoppinglist_share_with_status(int shoppinglist_share_with_status)
	{
		this.shoppinglist_share_with_status = shoppinglist_share_with_status;
	}
	public Timestamp getModify_date()
	{
		return modify_date;
	}
	public void setModify_date(Timestamp modify_date)
	{
		this.modify_date = modify_date;
	}
	public int getModifier_code()
	{
		return modifier_code;
	}
	public void setModifier_code(int modifier_code)
	{
		this.modifier_code = modifier_code;
	}
	public void setModifier_code(ModifierCodeReference modifier_code)
	{
		this.modifier_code = modifier_code.getModifierCode();
	}
}
