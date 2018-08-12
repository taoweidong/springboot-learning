package com.taowd.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author Taowd
 * @date 2018/3/23 - 17:48
 * @Description
 */
@Getter
@Setter
@ToString
public class User {
	/**
	 * 唯一Id
	 */
	private Long id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 年龄
	 */
	private int age;
	/**
	 * 出生日期
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm")
	private Date birthday;

}
