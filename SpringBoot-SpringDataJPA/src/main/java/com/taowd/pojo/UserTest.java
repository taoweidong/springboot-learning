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
 * @date 2018/4/4 - 13:06
 * @Description
 */
@Setter
@Getter
@Entity
@ToString
public class UserTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idTest;

    private String nameTest;
}
