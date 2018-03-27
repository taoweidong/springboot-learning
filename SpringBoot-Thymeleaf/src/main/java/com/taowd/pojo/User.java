package com.taowd.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Taowd
 * @date 2018/3/27 - 8:41
 * @Description
 */
@Setter
@Getter
@ToString
public class User {

    /**
     * ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
}
