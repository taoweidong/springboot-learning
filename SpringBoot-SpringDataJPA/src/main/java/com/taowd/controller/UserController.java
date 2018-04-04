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

    @RequestMapping("/save")
    public String save() {
        User user = new User();
        user.setName("李测试");
        user.setAge(25);
        userService.save(user);
        return "Save OK";
    }

    @RequestMapping("/update")
    public String update() {
        User user = new User();
        user.setId(3);
        user.setName("李修改");
        user.setAge(32);
        userService.save(user);
        return "update OK";
    }

    @RequestMapping("/delete")
    public String delete() {
        userService.delete(1);
        return "Delete OK";
    }

    @RequestMapping("/getAll")
    public Iterable<User> getAll() {
        return userService.getAll();
    }

    @RequestMapping("/findByName")
    public User findByName(String name) {
        return userService.findByName(name);
    }

}
