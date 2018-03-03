package com.gateway.controller;

import com.vzard.domain.User;
import com.vzard.fegin.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserClient userClient;

    @RequestMapping(value = "user/{name}",method = RequestMethod.GET)
    public User getUserByName(@PathVariable("name") String name){
        return userClient.getUserByName(name);
    }

}
