package com.chishenme.dao.friend;

import org.apache.ibatis.annotations.Param;

import com.chishenme.model.friend.UserPartner;

public interface UserPartnerMapper
{
	public void addUserPartner(UserPartner userPartner);
	
	public UserPartner selectLatestPartnerStatusByUserIdAndFriendId(@Param("user_id") int user_id, @Param("friend_id") int friend_id);
	
	public void updatePartnerStatus(UserPartner userPartner);
}
