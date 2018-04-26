package com.taowd.controller;

import com.taowd.pojo.SysUser;
import com.taowd.service.UserService;
import com.taowd.utils.JSONResult;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Taowd
 * @date 2018/4/24 - 14:01
 * @Description
 */
@RestController
@RequestMapping("/mybatis")
public class MyBatisCRUDController {

    private static final Logger logger = LoggerFactory.getLogger(MyBatisCRUDController.class);

    @Autowired
    private UserService userService;

    /**
     * 保存用户
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveUser")
    public JSONResult saveUser() throws Exception {
        SysUser sysUser = new SysUser();
        sysUser.setIdTest(RandomStringUtils.randomNumeric(20));
        sysUser.setNameTest("测试一下喽");

        userService.saveUser(sysUser);

        return JSONResult.ok(sysUser);
    }

    /**
     * 更新用户信息
     *
     * @return
     */
    @RequestMapping("/updataUser")
    public JSONResult updataUser() throws NullPointerException {

        SysUser sysUser = new SysUser();
        sysUser.setIdTest("1231");
        sysUser.setNameTest("更新之后的名称");

        userService.updateUser(sysUser);

        throw new NullPointerException();

//        return JSONResult.ok(sysUser);
    }

    /**
     * 根据Id删除用户信息
     *
     * @param userId
     * @return
     */
    @RequestMapping("/deleteUser")
    public JSONResult deleteUser(String userId) {

        userService.deleteUser(userId);

        return JSONResult.ok("删除成功:" + userId);
    }

    /**
     * 根据Id查询单个用户信息
     *
     * @param userId
     * @return
     */
    @RequestMapping("/queryUser")
    public JSONResult queryUserById(String userId) {

        return JSONResult.ok(userService.queryUserById(userId));
    }

    /**
     * 根据条件查询用户信息(多条)
     *
     * @param sysUser
     * @return
     */
    @RequestMapping("/queryUserList")
    public JSONResult queryUserList(SysUser sysUser) {
        List<SysUser> userList = userService.queryUserList(sysUser);
        return JSONResult.ok(userList);
    }


}
