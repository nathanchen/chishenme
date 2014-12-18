package com.chishenme.user.dao;

import com.chishenme.user.model.User;

import java.util.List;

/**
 * User: nathanchen Date: 18/12/2014 Time: 5:00 PM Description:
 */
public interface UserMapper
{
	public void addUser(User user);

	public List<User> getAllUsers();
}
