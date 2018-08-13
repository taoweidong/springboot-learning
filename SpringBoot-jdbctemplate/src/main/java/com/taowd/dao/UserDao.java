package com.taowd.dao;

import com.taowd.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * 
 * @ClassName: UserDao
 * @Description: 用户操作
 * @author Taowd
 * @date 2018年8月13日
 *
 */
@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 根据Id查询用户数据
	 *
	 * @param id
	 * @return
	 */
	public User getUserById(long id) {
		String sql = "select * from user where id=?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);

		return jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

	/**
	 * 获取单个列的值或做统计查询 使用 queryForObject(String sql, Class<Long> requiredType)
	 */
	public long testQueryForObject2() {
		String sql = "SELECT count(id) FROM user ";
		return jdbcTemplate.queryForObject(sql, Long.class);
	}
}
