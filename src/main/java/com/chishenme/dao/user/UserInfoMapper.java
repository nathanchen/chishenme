package com.chishenme.dao.user;

import com.chishenme.model.user.UserInfo;

public interface UserInfoMapper
{
	public void addUserInfo(UserInfo userInfo);
	
	public UserInfo selectUserInfoByUserId(int user_id);
	
	public int selectNumberOfUserInfoByUserId(int user_id);
}
