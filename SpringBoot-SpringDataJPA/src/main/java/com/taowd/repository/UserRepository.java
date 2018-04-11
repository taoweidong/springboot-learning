package com.taowd.repository;

import com.taowd.pojo.User;
import org.springframework.data.repository.CrudRepository;

/**
 * 接口文件
 * @author Taowd
 * @date 2018/4/2 - 13:20
 * @Description
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
