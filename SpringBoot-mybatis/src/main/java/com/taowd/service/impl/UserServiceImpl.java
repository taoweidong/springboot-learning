package com.taowd.service.impl;

import com.taowd.mapper.SysUserMapper;
import com.taowd.pojo.SysUser;
import com.taowd.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Taowd
 * @date 2018/4/24 - 14:09
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 新增用户
     *
     * @param sysUser
     * @throws Exception
     */
    @Override
    public void saveUser(SysUser sysUser) throws Exception {
        sysUserMapper.insert(sysUser);
    }

    /**
     * 更新用户
     *
     * @param sysUser
     */
    @Override
    public void updateUser(SysUser sysUser) {
        sysUserMapper.updateByPrimaryKey(sysUser);
    }

    /**
     * 删除用户
     *
     * @param id
     */
    @Override
    public void deleteUser(String id) {
        sysUserMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据Id查询
     *
     * @param userId
     * @return
     */
    @Override
    public SysUser queryUserById(String userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    /**
     * 条件查询
     *
     * @param sysUser
     * @return
     */
    @Override
    public List<SysUser> queryUserList(SysUser sysUser) {
        return sysUserMapper.select(sysUser);
    }
}
