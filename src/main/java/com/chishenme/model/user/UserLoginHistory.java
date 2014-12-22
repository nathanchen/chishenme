package com.chishenme.model.user;

import java.sql.Timestamp;

public class UserLoginHistory
{
	private int history_id;
	private int user_id;
	private Timestamp login_date;
	private String ip_addr;
	
	public UserLoginHistory() {}
	
	public UserLoginHistory(int user_id, String ip_addr)
	{
		this.user_id = user_id;
		this.ip_addr = ip_addr;
	}

	public int getHistory_id()
	{
		return history_id;
	}

	public void setHistory_id(int history_id)
	{
		this.history_id = history_id;
	}

	public int getUser_id()
	{
		return user_id;
	}

	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}

	public Timestamp getLogin_date()
	{
		return login_date;
	}

	public void setLogin_date(Timestamp login_date)
	{
		this.login_date = login_date;
	}

	public String getIp_addr()
	{
		return ip_addr;
	}

	public void setIp_addr(String ip_addr)
	{
		this.ip_addr = ip_addr;
	}
}
