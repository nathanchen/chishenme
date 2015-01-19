package com.chishenme.model.shoppinglist;

import java.sql.Timestamp;

import com.chishenme.config.ModifierCodeReference;

public class ShoppinglistInfo
{
	private long entry_id;
	private long item_id;
	private int shoppinglist_id;
	private Timestamp modify_date;
	private int modifier_code;

	public ShoppinglistInfo()
	{

	}

	public ShoppinglistInfo(int shoppinglist_id, long item_id, int modifier_code)
	{
		super();
		this.shoppinglist_id = shoppinglist_id;
		this.item_id = item_id;
		this.modifier_code = modifier_code;
	}

	public long getItem_id()
	{
		return item_id;
	}

	public void setItem_id(long item_id)
	{
		this.item_id = item_id;
	}

	public int getShoppinglist_id()
	{
		return shoppinglist_id;
	}

	public void setShoppinglist_id(int shoppinglist_id)
	{
		this.shoppinglist_id = shoppinglist_id;
	}

	public long getEntry_id()
	{
		return entry_id;
	}

	public void setEntry_id(long entry_id)
	{
		this.entry_id = entry_id;
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
