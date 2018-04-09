package com.taowd.repository;

import com.taowd.pojo.User;
import org.springframework.data.repository.Repository;

/**
 * @author Taowd
 * @date 2018/4/4 - 14:04
 * @Description
 */
public interface User2Repository extends Repository<User, Integer> {
    /**
     * 根据name查询
     * @param name
     * @return
     */
    public User findByName(String name);
}