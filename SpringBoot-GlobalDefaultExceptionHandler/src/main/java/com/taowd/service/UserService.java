package com.taowd.service;

import com.taowd.pojo.User;
import com.taowd.repository.User2Repository;
import com.taowd.repository.UserRepository;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * @author Taowd
 * @date 2018/4/2 - 13:22
 * @Description
 */
@Service
public class UserService {

  @Resource
  private UserRepository userRepository;

  @Resource
  private User2Repository user2Repository;

  /**
   * 保存数据
   * @param user
   */
  @Transactional
  public void save(User user) {
    userRepository.save(user);
  }

  /**
   * 更新数据
   * @param user
   */
  @Transactional
  public void update(User user) {

    userRepository.save(user);
  }

  /**
   * 删除数据
   * @param id
   */
  //添加事务绑定
  @Transactional(rollbackOn = Exception.class)
  public void delete(int id) {
    userRepository.deleteById(id);
  }

  /**
   * 查询所有数据
   * @return
   */
  public Iterable<User> getAll() {

    int x = 12 / 0;

    return userRepository.findAll();
  }


  /**
   * 根据用户名查询数据
   * @param name
   * @return
   */
  public User findByName(String name) {
    return user2Repository.findByName(name);
  }

}
