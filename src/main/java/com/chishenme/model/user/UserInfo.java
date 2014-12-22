package com.chishenme.model.user;

import java.sql.Timestamp;

import com.chishenme.config.ModifierCode;

public class UserInfo
{
	private int user_id;
	private String first_name;
	private String last_name;
	private String email;
	private int age;
	private char gender;
	private Timestamp register_date;
	private String user_city;
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
	public String getFirst_name()
	{
		return first_name;
	}
	public void setFirst_name(String first_name)
	{
		this.first_name = first_name;
	}
	public String getLast_name()
	{
		return last_name;
	}
	public void setLast_name(String last_name)
	{
		this.last_name = last_name;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public char getGender()
	{
		return gender;
	}
	public void setGender(char gender)
	{
		this.gender = gender;
	}
	public Timestamp getRegister_date()
	{
		return register_date;
	}
	public void setRegister_date(Timestamp register_date)
	{
		this.register_date = register_date;
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
}
