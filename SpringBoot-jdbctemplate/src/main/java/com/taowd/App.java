package com.taowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 
 * @ClassName: App
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Taowd
 * @date 2018年8月13日
 *
 */
@SpringBootApplication
@Controller
public class App {

	@Resource
	private JdbcTemplate jdbcTemplate;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	public static void main(String[] args) {

		SpringApplication.run(App.class, args);

	}
}
