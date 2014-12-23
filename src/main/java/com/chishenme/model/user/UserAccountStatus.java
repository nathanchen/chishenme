package com.chishenme.model.user;

import java.sql.Timestamp;

import com.chishenme.config.ModifierCodeReference;
import com.chishenme.config.StatusReference;

public class UserAccountStatus
{
	private int user_id;
	private int status;
	private Timestamp modify_date;
	private int modifier_code;
	
	public UserAccountStatus() {}
	
	public UserAccountStatus(int user_id, int status,
			int modifier_code)
	{
		super();
		this.user_id = user_id;
		this.status = status;
		this.modifier_code = modifier_code;
	}

	public int getUser_id()
	{
		return user_id;
	}
	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
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
	public void setModifier_code(ModifierCodeReference modifier_code)
	{
		this.modifier_code = modifier_code.getModifierCode();
	}
}
