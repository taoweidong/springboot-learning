package com.taowd.pojo;

import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser {
    @Id
    @Column(name = "id_test")
    private String idTest;

    @Column(name = "name_test")
    private String nameTest;

    /**
     * @return id_test
     */
    public String getIdTest() {
        return idTest;
    }

    /**
     * @param idTest
     */
    public void setIdTest(String idTest) {
        this.idTest = idTest;
    }

    /**
     * @return name_test
     */
    public String getNameTest() {
        return nameTest;
    }

    /**
     * @param nameTest
     */
    public void setNameTest(String nameTest) {
        this.nameTest = nameTest;
    }
}