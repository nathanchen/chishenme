package com.chishenme.model.response.friend;

import java.util.ArrayList;

public class FriendRequestsResponseModel
{
	private int code;
	ArrayList<FriendRequest> friendRequests;
	
	public FriendRequestsResponseModel() {}
	
	public FriendRequestsResponseModel(int code,
			ArrayList<FriendRequest> friendRequests)
	{
		super();
		this.code = code;
		this.friendRequests = friendRequests;
	}

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public ArrayList<FriendRequest> getFriendRequests()
	{
		return friendRequests;
	}

	public void setFriendRequests(ArrayList<FriendRequest> friendRequests)
	{
		this.friendRequests = friendRequests;
	}

	class FriendRequest
	{
		private int code;
		private int user_id;
		private String user_name;
		
		public int getCode()
		{
			return code;
		}
		public void setCode(int code)
		{
			this.code = code;
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
	}
}
