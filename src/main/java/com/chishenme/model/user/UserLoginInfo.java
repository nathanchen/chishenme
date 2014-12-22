package com.chishenme.model.user;

import java.sql.Timestamp;

import com.chishenme.config.ModifierCode;
import com.chishenme.config.Status;

public class UserLoginInfo
{
	private int entry_id;
	private int user_id;
	private String user_name;
	private String password;
	private String encrypt_user_name;
	private int status;
	private String user_city;
	private Timestamp modify_date;
	private int modifier_code;
	
	public UserLoginInfo() {}
	
	public UserLoginInfo(int user_id, String user_name, String password,
			String encrypt_user_name, int status, int modifier_code)
	{
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.encrypt_user_name = encrypt_user_name;
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
	public String getEncrypt_user_name()
	{
		return encrypt_user_name;
	}
	public void setEncrypt_user_name(String encrypt_user_name)
	{
		this.encrypt_user_name = encrypt_user_name;
	}
	public int getStatus()
	{
		return status;
	}
	public void setStatus(int status)
	{
		this.status = status;
	}
	public void setStatus(Status status)
	{
		this.status = status.getStatusCode();
	}
	public String getUser_city()
	{
		return user_city;
	}
	public void setUser_city(String user_city)
	{
		this.user_city = user_city;
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
	public void setModifier_code(ModifierCode modifier_code)
	{
		this.modifier_code = modifier_code.getModifierCode();
	}
	public void setModifier_code(int modifier_code)
	{
		this.modifier_code = modifier_code;
	}
}
