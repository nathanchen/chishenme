package com.chishenme.model.shoppinglist;

import java.sql.Timestamp;

import com.chishenme.config.ModifierCodeReference;

public class ShoppinglistItem
{
	private long entry_id;
	private int creator_id;
	private String subject;
	private int quantity;
	private String unit;
	private int shoppinglist_item_status;
	private Timestamp modify_date;
	private int modifier_code;

	public ShoppinglistItem()
	{

	}
	
	public ShoppinglistItem(int creator_id, String subject,
			int quantity, String unit,
			int shoppinglist_item_status, int modifier_code)
	{
		super();
		this.creator_id = creator_id;
		this.subject = subject;
		this.quantity = quantity;
		this.unit = unit;
		this.shoppinglist_item_status = shoppinglist_item_status;
		this.modifier_code = modifier_code;
	}
	
	public long getEntry_id()
	{
		return entry_id;
	}
	public void setEntry_id(long entry_id)
	{
		this.entry_id = entry_id;
	}
	public int getCreator_id()
	{
		return creator_id;
	}
	public void setCreator_id(int creator_id)
	{
		this.creator_id = creator_id;
	}
	public String getSubject()
	{
		return subject;
	}
	public void setSubject(String subject)
	{
		this.subject = subject;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	public String getUnit()
	{
		return unit;
	}
	public void setUnit(String unit)
	{
		this.unit = unit;
	}
	public int getShoppinglist_item_status()
	{
		return shoppinglist_item_status;
	}
	public void setShoppinglist_item_status(int shoppinglist_item_status)
	{
		this.shoppinglist_item_status = shoppinglist_item_status;
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
