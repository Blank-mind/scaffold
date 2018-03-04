package com.appauth.controller;

import com.appauth.annotation.Authorization;
import com.appauth.annotation.CurrentUser;
import com.appauth.authorization.manager.TokenManager;
import com.appauth.authorization.model.TokenModel;
import com.appauth.config.ResultStatus;
import com.appauth.domain.User;
import com.appauth.model.ResultModel;
import com.appauth.repository.UserRepository;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tokens")
public class TokenController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenManager tokenManager;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value = "登录")
    public ResponseEntity<ResultModel> login(@RequestParam("name") String name, @RequestParam("password") String password) {
        Assert.notNull(name, "username can not be empty");
        Assert.notNull(password, "password can not empty");

        User user = userRepository.findByName(name);
        if (user == null || !user.getPassword().equals(password)) {
            return new ResponseEntity<ResultModel>(ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.NOT_FOUND);
        }

        TokenModel token = tokenManager.createToken(user.getId());
        System.out.println(token.getToken());
        System.out.println(token.getUserId());
        return new ResponseEntity<ResultModel>(ResultModel.ok(token), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @Authorization
    @ApiOperation(value = "退出登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseEntity<ResultModel> logout(@CurrentUser User user) {
        tokenManager.deleteToken(user.getId());
        return new ResponseEntity<ResultModel>(ResultModel.ok(), HttpStatus.OK);
    }

}
