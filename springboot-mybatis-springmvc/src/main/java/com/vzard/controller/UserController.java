package com.vzard.controller;

import com.vzard.fegin.UserClient;
import com.vzard.domain.User;
import com.vzard.domain.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserClient {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(@RequestBody User user) {
        return userMapper.insertByUser(user);
    }

    @Override
    public User getUserByName(@PathVariable String name) {
        return userMapper.findByName(name);
    }
}
