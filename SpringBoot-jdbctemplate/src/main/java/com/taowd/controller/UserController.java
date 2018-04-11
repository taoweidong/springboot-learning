package com.taowd.controller;

import com.taowd.pojo.User;
import com.taowd.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Taowd
 * @date 2018/4/2 - 13:24
 * @Description
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;


    @RequestMapping("/findById")
    public User findById(long id) {
        return userService.getUserById(id);
    }

    @RequestMapping("/getCount")
    public String getCount() {
        return "User表的总数为：" + userService.getCount();
    }

}
