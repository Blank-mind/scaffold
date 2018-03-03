package com.vzard.fegin;

import com.vzard.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        name = "user",
        url = "${user.server}"
)
public interface UserClient {

    @RequestMapping(value = "user/",method = RequestMethod.POST)
    public int addUser(@RequestBody User user);

    @RequestMapping(value = "user/{name}")
    public User getUserByName(@PathVariable("name") String name);

}
