package com.chishenme.model.shoppinglist;

import java.sql.Timestamp;

import com.chishenme.config.ModifierCodeReference;

public class Shoppinglist
{
	private int shoppinglist_id;
	private int creator_id;
	private String subject;
	private int shoppinglist_status;
	private Timestamp modify_date;
	private int modifier_code;
	
	public Shoppinglist()
	{
		
	}
	
	public Shoppinglist(int creator_id, String subject,
			int shoppinglist_status, int modifier_code)
	{
		super();
		this.creator_id = creator_id;
		this.subject = subject;
		this.shoppinglist_status = shoppinglist_status;
		this.modifier_code = modifier_code;
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
	public String getSubject()
	{
		return subject;
	}
	public void setSubject(String subject)
	{
		this.subject = subject;
	}
	public int getShoppinglist_status()
	{
		return shoppinglist_status;
	}
	public void setShoppinglist_status(int shoppinglist_status)
	{
		this.shoppinglist_status = shoppinglist_status;
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
