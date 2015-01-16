package com.chishenme.dao.user;

import com.chishenme.model.user.UserAccountStatus;

public interface UserAccountStatusMapper
{
	public void addANewUserAccountStatus(UserAccountStatus userAccountStatus);
	
	public UserAccountStatus selectLatestUserAccountStatus(int user_id);
}
