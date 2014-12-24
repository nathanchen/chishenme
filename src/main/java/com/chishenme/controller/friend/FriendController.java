package com.chishenme.controller.friend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chishenme.config.ModifierCodeReference;
import com.chishenme.config.RtnCodeReference;
import com.chishenme.config.StatusReference;
import com.chishenme.dao.friend.FriendBlackListInfoMapper;
import com.chishenme.dao.friend.UserPartnerMapper;
import com.chishenme.dao.user.UserInfoMapper;
import com.chishenme.model.friend.FriendBlackListInfo;
import com.chishenme.model.friend.UserPartner;
import com.chishenme.model.response.friend.FriendAddResponseModel;


@RestController
public class FriendController
{
	private static final Logger logger = LoggerFactory.getLogger(FriendController.class);
	
	@Autowired
	private UserPartnerMapper userPartnerMapper;
	
	@Autowired
	private UserInfoMapper UserInfoMapper;
	
	@Autowired
	private FriendBlackListInfoMapper friendBlacklistInfoMapper;
	
	@RequestMapping(value = "/friend/add")
    @Transactional
    public FriendAddResponseModel requestToAddFriend(@RequestParam("userid") int user_id, @RequestParam("friendid") int friend_id)
    {
		int code = RtnCodeReference.FRIEND_REQUESTTOADDFRIEND_REQUEST_FINISHED_SUCCESSFULLY.getRtnCode();
		
		// cannot add self as friend
		if (user_id == friend_id)
		{
			code = RtnCodeReference.FRIEND_REQUESTTOADDFRIEND_CANNOT_FRIEND_SELF.getRtnCode();
			return new FriendAddResponseModel(code);
		}
		
		// user_id is valid 
		if (UserInfoMapper.selectNumberOfUserInfoByUserId(user_id) != 1)
		{
			code = RtnCodeReference.FRIEND_REQUESTTOADDFRIEND_INVALID_USERID.getRtnCode();
			return new FriendAddResponseModel(code);
		}
		
		// friend_id is valid
		if (UserInfoMapper.selectNumberOfUserInfoByUserId(friend_id) != 1)
		{
			code = RtnCodeReference.FRIEND_REQUESTTOADDFRIEND_INVALID_FRIENDID.getRtnCode();
			return new FriendAddResponseModel(code);
		}
		
		// if user and friend partnership has recorded in user_partner table
		UserPartner userPartner = userPartnerMapper.selectLatestPartnerStatusByUserIdAndFriendId(user_id, friend_id);
		if (userPartner != null)
		{
			// already are friends
			if (userPartner.getStatus() == StatusReference.USER_PARTNER_STATUS_FRIEND.getStatusCode())
			{
				code = RtnCodeReference.FRIEND_REQUESTTOADDFRIEND_ARE_ALREADY_FRIENDS.getRtnCode();
				return new FriendAddResponseModel(code);
			}
			
			// request not pending
			if (userPartner.getStatus() == StatusReference.USER_PARTNER_STATUS_WAITINGFORREPLY.getStatusCode())
			{
				code = RtnCodeReference.FRIEND_REQUESTTOADDFRIEND_FRIEND_REQUEST_STILL_PENDING.getRtnCode();
				return new FriendAddResponseModel(code);
			}
		}
		
		// user_id is not in friend's black list && status is normal
		FriendBlackListInfo friendBlackListInfo = friendBlacklistInfoMapper.selectLatestFriendBlackListInfoByUserIdAndObjectId(friend_id, user_id);
		if ((friendBlackListInfo != null) && (friendBlackListInfo.getStatus() == StatusReference.FRIEND_BLACK_LIST_INFO_STATUS_NORMAL.getStatusCode()))
		{
			code = RtnCodeReference.FRIEND_REQUESTTOADDFRIEND_USER_IS_BLACKLISTED.getRtnCode();
			return new FriendAddResponseModel(code);
		}
		
		// add friend
		// remove this object from user's blacklist if any (add a new entry)
		if (friendBlacklistInfoMapper.selectLatestFriendBlackListInfoByUserIdAndObjectId(user_id, friend_id) != null)
		{
			friendBlackListInfo = new FriendBlackListInfo(user_id, friend_id, 
					StatusReference.FRIEND_BLACK_LIST_INFO_STATUS_CANCELLED.getStatusCode(), ModifierCodeReference.SELF.getModifierCode());
			friendBlacklistInfoMapper.addFriendBlackListInfo(friendBlackListInfo);
		}
		
		// if friend's request is pending, then change it to NORMAL; and user's request is normal
		userPartner = userPartnerMapper.selectLatestPartnerStatusByUserIdAndFriendId(friend_id, user_id);
		if ((userPartner != null) && (userPartner.getStatus() == StatusReference.USER_PARTNER_STATUS_WAITINGFORREPLY.getStatusCode()))
		{
			userPartnerMapper.addUserPartner(new UserPartner(friend_id, user_id, StatusReference.USER_PARTNER_STATUS_FRIEND.getStatusCode(), ModifierCodeReference.SYSTEM.getModifierCode()));
			userPartnerMapper.addUserPartner(new UserPartner(user_id, friend_id, StatusReference.USER_PARTNER_STATUS_FRIEND.getStatusCode(), ModifierCodeReference.SELF.getModifierCode()));
			code = RtnCodeReference.FRIEND_REQUESTTOADDFRIEND_BECOME_FRIENDS.getRtnCode();
			return new FriendAddResponseModel(code);
		}
		
		// user initial the request, save it as WAITINGFORREPLY
		userPartner = new UserPartner(user_id, friend_id, StatusReference.USER_PARTNER_STATUS_WAITINGFORREPLY.getStatusCode(), ModifierCodeReference.SELF.getModifierCode());
		userPartnerMapper.addUserPartner(userPartner);
		return new FriendAddResponseModel(code);
    }
}

