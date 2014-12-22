package com.chishenme.model.user;

import java.sql.Timestamp;

import com.chishenme.config.ModifierCode;

/**
 * User: nathanchen Date: 18/12/2014 Time: 5:01 PM Description:
 */
public class User
{
    private int user_id;
    private String user_name;
    private String password;
    private Timestamp modify_date;
    private int modifier_code;
    
	public int getUser_id()
	{
		return user_id;
	}
	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}
	public String getUser_name()
	{
		return user_name;
	}
	public void setUser_name(String user_name)
	{
		this.user_name = user_name;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
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
	public void setModifier_code(ModifierCode modifier_code)
	{
		this.modifier_code = modifier_code.getModifierCode();
	}
}
