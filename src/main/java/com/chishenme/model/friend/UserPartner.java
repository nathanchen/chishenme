package com.chishenme.model.friend;

import java.sql.Timestamp;

import com.chishenme.config.ModifierCodeReference;
import com.chishenme.config.StatusReference;

public class UserPartner
{
	private int entry_id;
	private int user_id;
	private int friend_id;
	private int status;
	private Timestamp modify_date;
	private int modifier_code;
	
	public UserPartner() {}

	public UserPartner(int user_id, int friend_id, int status, int modifier_code)
	{
		super();
		this.user_id = user_id;
		this.friend_id = friend_id;
		this.status = status;
		this.modifier_code = modifier_code;
	}

	public int getEntry_id()
	{
		return entry_id;
	}

	public void setEntry_id(int entry_id)
	{
		this.entry_id = entry_id;
	}

	public int getUser_id()
	{
		return user_id;
	}

	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}

	public int getFriend_id()
	{
		return friend_id;
	}

	public void setFriend_id(int friend_id)
	{
		this.friend_id = friend_id;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}
	
	public void setStatus(StatusReference status)
	{
		this.status = status.getStatusCode();
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
	
	public void setModifier_code(ModifierCodeReference modifierCode)
	{
		this.modifier_code = modifierCode.getModifierCode();
	}
}
