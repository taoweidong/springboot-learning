package com.taowd.service;

import com.taowd.pojo.SysUser;

import java.util.List;

/**
 * @author Taowd
 * @date 2018/4/24 - 14:08
 * @Description
 */
public interface UserService {
    public void saveUser(SysUser sysUser) throws Exception;

    public void updateUser(SysUser sysUser);

    public void deleteUser(String id);

    public SysUser queryUserById(String userId);

    public List<SysUser> queryUserList(SysUser sysUser);
}
