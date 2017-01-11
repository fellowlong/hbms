package com.newstar.hbms.system.service.impl;

import com.newstar.hbms.system.dao.UserDao;
import com.newstar.hbms.system.domain.User;
import com.newstar.hbms.system.service.UserService;

import java.util.List;

/**
 * Created by fellowlong on 2014-10-30.
 */
public class UserServiceImpl implements UserService {

  private UserDao userDao;

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public int insert(User user) {
    return 0;
  }

  @Override
  public int update(User user) {
    return 0;
  }

  @Override
  public int deleteByIds(Long[] authorityIds) {
    return 0;
  }

  @Override
  public List<User> findAll() {
    return userDao.findAll();
  }

  @Override
  public User findByUri(String uri) {
    return null;
  }

  @Override
  public List<User> findByIds(Long[] ids) {
    return null;
  }
}
