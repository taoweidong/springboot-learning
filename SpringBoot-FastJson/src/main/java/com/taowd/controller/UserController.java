package com.taowd.controller;

import com.taowd.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 
 * @ClassName: UserController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Taowd
 * @date 2018年8月12日
 *
 */
@RestController
public class UserController {

	@GetMapping("/getUser")
	public User getUser() {
		User user = new User();
		user.setId(900L);
		user.setName("离散测试");
		user.setBirthday(new Date());
		return user;
	}
}
