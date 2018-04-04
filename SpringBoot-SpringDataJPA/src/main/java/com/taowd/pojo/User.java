package com.taowd.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Taowd
 * @date 2018/4/2 - 13:06
 * @Description
 */
@Setter
@Getter
@ToString
@Entity
public class User {

    /**
     * ID 唯一标识
     */
    @Id
    //指定主键的生成策略，MySql默认是自增长
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
}
