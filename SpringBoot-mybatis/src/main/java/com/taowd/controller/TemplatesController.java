package com.taowd.controller;

import com.taowd.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author Taowd
 * @date 2018/3/26 - 20:13
 * @Description
 */
@Controller
@RequestMapping("/hello")
public class TemplatesController {

    @RequestMapping("/index")
    public String hello(Map<String, Object> map) {
        // ModelAndView modelAndView = new ModelAndView("hello");
        // modelAndView.add
        map.put("name", "Andy");
        map.put("hello", "测试一下喽！！！！");
        //return modelAndView;
        User user = new User();
        user.setId(99);
        user.setName("李三");
        user.setAge(25);

        map.put("user", user);

        return "test";

    }

}
