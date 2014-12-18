package com.chishenme.user.controller;

import com.chishenme.user.model.User;
import com.chishenme.user.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User: nathanchen Date: 18/12/2014 Time: 5:02 PM Description:
 */
@RestController
public class UserController
{
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/user/add")
    public List createUser(@RequestParam("name") String name)
    {
        User user = new User();
        user.setName(name);
        userMapper.addUser(user);

        return userMapper.getAllUsers();
    }
}
