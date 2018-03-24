package com.taowd.controller;

import com.taowd.pojo.User;
import com.taowd.utils.JSONResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Taowd
 * @date 2018/3/23 - 17:51
 * @Description
 */
@RestController
public class UserController {

    @GetMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setId(10L);
        user.setName("李三");
        user.setBirthday(new Date());

        return user;
    }

    @GetMapping("/getJsonUser")
    public JSONResult getJsonUser() {
        User user = new User();
        user.setId(10L);
        user.setName("李三");
        user.setBirthday(new Date());

        return JSONResult.ok(user);
    }
}
