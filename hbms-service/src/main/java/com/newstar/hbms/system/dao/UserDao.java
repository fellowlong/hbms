package com.newstar.hbms.system.dao;

import com.newstar.hbms.system.domain.User;

import java.util.List;

/**
 * Created by fellowlong on 2014-10-30.
 */
public interface UserDao {

  public int insert(User user);

  public int update(User user);

  public int deleteByIds(Long[] authorityIds);

  public List<User> findAll();

  public User findByUri(String uri);

  public List<User> findByIds(Long[] ids);
  
}
