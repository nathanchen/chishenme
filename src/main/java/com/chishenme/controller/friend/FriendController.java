package com.chishenme.controller.friend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chishenme.config.ModifierCode;
import com.chishenme.config.Status;
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
		String code = "0";
		
		// user_id is valid 
		if (UserInfoMapper.selectNumberOfUserInfoByUserId(user_id) != 1)
		{
			code = "1";
			return new FriendAddResponseModel(code);
		}
		
		// friend_id is valid
		if (UserInfoMapper.selectNumberOfUserInfoByUserId(friend_id) != 1)
		{
			code = "2";
			return new FriendAddResponseModel(code);
		}
		
		// if user and friend partnership has recorded in user_partner table
		UserPartner userPartner = userPartnerMapper.selectLatestPartnerStatusByUserIdAndFriendId(user_id, friend_id);
		if (userPartner != null)
		{
			// not partner yet
			if (userPartner.getStatus() == Status.USER_PARTNER_STATUS_FRIEND.getStatusCode())
			{
				code = "3";
				return new FriendAddResponseModel(code);
			}
			
			// request not pending
			if (userPartner.getStatus() == Status.USER_PARTNER_STATUS_WAITINGFORREPLY.getStatusCode())
			{
				code = "4";
				return new FriendAddResponseModel(code);
			}
		}
		
		// user_id is not in friend's black list && status is normal
		FriendBlackListInfo friendBlackListInfo = friendBlacklistInfoMapper.selectLatestFriendBlackListInfoByUserIdAndObjectId(friend_id, user_id);
		if ((friendBlackListInfo != null) && (friendBlackListInfo.getStatus() == Status.FRIEND_BLACK_LIST_INFO_STATUS_NORMAL.getStatusCode()))
		{
			code = "5";
			return new FriendAddResponseModel(code);
		}
		
		// add friend
		// remove this object from user's blacklist if any (add a new entry)
		if (friendBlacklistInfoMapper.selectLatestFriendBlackListInfoByUserIdAndObjectId(user_id, friend_id) != null)
		{
			friendBlackListInfo = new FriendBlackListInfo(user_id, friend_id, 
					Status.FRIEND_BLACK_LIST_INFO_STATUS_CANCELLED.getStatusCode(), ModifierCode.SELF.getModifierCode());
			friendBlacklistInfoMapper.addFriendBlackListInfo(friendBlackListInfo);
		}
		
		// if friend's request is pending, then change it to NORMAL; and user's request is normal
		userPartner = userPartnerMapper.selectLatestPartnerStatusByUserIdAndFriendId(friend_id, user_id);
		if ((userPartner != null) && (userPartner.getStatus() == Status.USER_PARTNER_STATUS_WAITINGFORREPLY.getStatusCode()))
		{
			userPartnerMapper.addUserPartner(new UserPartner(friend_id, user_id, Status.USER_PARTNER_STATUS_FRIEND.getStatusCode(), ModifierCode.SYSTEM.getModifierCode()));
			userPartnerMapper.addUserPartner(new UserPartner(user_id, friend_id, Status.USER_PARTNER_STATUS_FRIEND.getStatusCode(), ModifierCode.SELF.getModifierCode()));
			code = "6";
			return new FriendAddResponseModel(code);
		}
		
		// user initial the request, save it as WAITINGFORREPLY
		userPartner = new UserPartner(user_id, friend_id, Status.USER_PARTNER_STATUS_WAITINGFORREPLY.getStatusCode(), ModifierCode.SELF.getModifierCode());
		userPartnerMapper.addUserPartner(userPartner);
		return new FriendAddResponseModel(code);
    }
}

