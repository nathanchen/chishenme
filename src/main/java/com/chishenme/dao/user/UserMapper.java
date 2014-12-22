package com.chishenme.dao.user;

import com.chishenme.model.user.User;
import com.chishenme.model.user.UserInfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * User: nathanchen Date: 18/12/2014 Time: 5:00 PM Description:
 */
public interface UserMapper
{
	public void addUser(User user);

	public List<User> getAllUsers();
	
	public int getNumberOfUsersByName(String name);
	
	public int getNumberOfUsersByNameAndPassword(@Param("name") String name, @Param("password") String password);
	
	public List<User> getUsersByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
