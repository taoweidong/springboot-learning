package com.taowd.pojo;

import javax.persistence.*;

public class User {
    /**
     * 唯一ID
     */
    @Id
    private Integer id;

    /**
     * 年齡
     */
    private Integer age;

    /**
     * 姓名
     */
    private String name;

    /**
     * 获取唯一ID
     *
     * @return id - 唯一ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置唯一ID
     *
     * @param id 唯一ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取年齡
     *
     * @return age - 年齡
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年齡
     *
     * @param age 年齡
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }
}