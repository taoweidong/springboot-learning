package com.taowd.service;

import com.taowd.dao.UserDao;
import com.taowd.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Taowd
 * @date 2018/4/2 - 13:22
 * @Description
 */
@Service
public class UserService {

	@Resource
	private UserDao userDao;

	/**
	 * 根据Id查询单个用户
	 *
	 * @param id
	 * @return
	 */
	public User getUserById(long id) {
		return userDao.getUserById(id);
	}

	/**
	 * 查询用户总数
	 *
	 * @return
	 */
	public long getCount() {
		return userDao.testQueryForObject2();
	}
}
