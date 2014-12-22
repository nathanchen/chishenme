package com.chishenme.controller.user;

import java.util.ArrayList;

import com.chishenme.config.ModifierCode;
import com.chishenme.config.Status;
import com.chishenme.dao.user.UserAccountStatusMapper;
import com.chishenme.dao.user.UserInfoMapper;
import com.chishenme.dao.user.UserLoginHistoryMapper;
import com.chishenme.dao.user.UserLoginInfoMapper;
import com.chishenme.dao.user.UserMapper;
import com.chishenme.model.criteria.user.UserCriteria;
import com.chishenme.model.response.user.UserAddResponseModel;
import com.chishenme.model.response.user.UserLoginResponseModel;
import com.chishenme.model.user.User;
import com.chishenme.model.user.UserAccountStatus;
import com.chishenme.model.user.UserInfo;
import com.chishenme.model.user.UserLoginHistory;
import com.chishenme.model.user.UserLoginInfo;
import com.chishenme.util.MD5Encryption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * User: nathanchen Date: 18/12/2014 Time: 5:02 PM Description:
 */
@RestController
public class UserController
{
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private UserAccountStatusMapper userAccountStatusMapper;
    
    @Autowired
    private UserInfoMapper userInfoMapper;
    
    @Autowired
    private UserLoginInfoMapper userLoginInfoMapper;
    
    @Autowired
    private UserLoginHistoryMapper UserLoginHistoryMapper;

    @RequestMapping(value = "/user/add")
    @Transactional
    public UserAddResponseModel createUser(@RequestParam("name") String name,
    		@RequestParam("pwd") String password, 
    		@RequestParam("confirm_pwd") String confirm_password,
    		HttpServletRequest httpServletRequest)
    {
    	UserInfo userInfo = new UserInfo();
    	String code = "0";
    	String userName = "";
    	
    	// confirm password matches password
    	if (! matchConfirmPassword(password, confirm_password))
    	{
    		code = "1";
    		return new UserAddResponseModel(code, userName, userInfo);
    	}
    	
    	// valid name format
    	if (! UserCriteria.isValidUserNameFormat(name))
		{
			code = "2";
			return new UserAddResponseModel(code, userName, userInfo);
		}
    	userName = name;
    	
    	// valid password format
    	if (! UserCriteria.isValidPasswordFormat(password))
    	{
    		code = "3";
    		return new UserAddResponseModel(code, userName, userInfo);
    	}
    	
    	// no duplicate user
    	if (userMapper.getNumberOfUsersByName(name) > 0)
    	{
    		code = "4";
    		return new UserAddResponseModel(code, userName, userInfo);
    	}
    	
    	// add a new UserInfo
    	userInfo.setModifier_code(ModifierCode.SYSTEM);
    	userInfoMapper.addUserInfo(userInfo);
        
        // get user_id for future reference
        int user_id = userInfo.getUser_id();
        logger.debug("user_id: {}", user_id);
        
        // add a new UserAccountStatus
        UserAccountStatus userAccountStatus = new UserAccountStatus();
        userAccountStatus.setUser_id(user_id);
        userAccountStatus.setModifier_code(ModifierCode.SYSTEM);
        userAccountStatus.setStatus(Status.USER_STATUS_NORMAL);
        userAccountStatusMapper.addANewUserAccountStatus(userAccountStatus);
        
        // add a new User
        User user = new User();
        user.setUser_id(user_id);
        user.setUser_name(name);
        user.setPassword(MD5Encryption.encrypt(password));
        user.setModifier_code(ModifierCode.SYSTEM);
        userMapper.addUser(user);

        String ip_addr = httpServletRequest.getRemoteAddr();
        logger.debug(ip_addr);
        
        return new UserAddResponseModel(code, userName, userInfo);
    }
    
    @RequestMapping("user/login")
    @Transactional
    public UserLoginResponseModel login(@RequestParam("name") String name, @RequestParam("pwd") String password,
    		HttpServletRequest httpServletRequest)
	{
		String code = "0";
		int user_id = 0;
		String userName = "";
		
		// name is not null or empty
		if (name == null || name.trim().equals(""))
		{
			code = "1";
			return new UserLoginResponseModel(code, user_id, userName);
		}
		
		// password is not null or empty
		if (password == null || password.trim().equals(""))
		{
			code = "2";
			return new UserLoginResponseModel(code, user_id, userName);
		}
		
		// only one entry in DB has the same username and password
		ArrayList<User> userList = (ArrayList<User>) userMapper.getUsersByNameAndPassword(name, MD5Encryption.encrypt(password));
		int numberOfUsersHasTheSameUsernameAndPassword = userList.size();
		if (numberOfUsersHasTheSameUsernameAndPassword <= 0)
		{
			code = "3";
			return new UserLoginResponseModel(code, user_id, userName);
		}
		
		// the account is valid
		if (numberOfUsersHasTheSameUsernameAndPassword > 1)
		{
			code = "4";
			return new UserLoginResponseModel(code, user_id, userName);
		}
		
		User user = userList.get(0);
		user_id = user.getUser_id();
		userName = name;
		
		// add a new UserLoginInfo
		UserLoginInfo userLoginInfo = new UserLoginInfo(user_id, userName, 
					password, MD5Encryption.encrypt(password), 
					Status.USER_LOGIN_INFO_STATUS_NORMAL.getStatusCode(), 
					ModifierCode.SYSTEM.getModifierCode());
		userLoginInfoMapper.addUserLoginInfo(userLoginInfo);
		
        // add a new UserLoginHistory
		String ip_addr = httpServletRequest.getRemoteAddr();
		UserLoginHistory userLoginHistory = new UserLoginHistory(user_id, ip_addr);
		UserLoginHistoryMapper.addUserLoginHistory(userLoginHistory);
		
		
		// return necessary cookies
		
		return new UserLoginResponseModel(code, user_id, userName);
	}
    
    private boolean matchConfirmPassword(String password, String confirm_password)
	{
		return password.equals(confirm_password);
	}
    
    
}
