package com.chishenme.dao.friend;

import org.apache.ibatis.annotations.Param;

import com.chishenme.model.friend.FriendBlackListInfo;

public interface FriendBlackListInfoMapper
{
	public FriendBlackListInfo selectLatestFriendBlackListInfoByUserIdAndObjectId(@Param("user_id") int user_id, @Param("sensor_object_id") int sensor_object_id);
	
	public void addFriendBlackListInfo(FriendBlackListInfo friendBlackListInfo);
}
