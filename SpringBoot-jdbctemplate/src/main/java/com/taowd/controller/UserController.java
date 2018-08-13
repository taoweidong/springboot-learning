package com.taowd.controller;

import com.taowd.pojo.User;
import com.taowd.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 
 * @ClassName UserController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Taowd
 * @date 2018年8月13日
 *
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
