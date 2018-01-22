package com.newstar.hbms.system.service.impl;

import com.newstar.hbms.system.dao.AuthorityDao;
import com.newstar.hbms.system.domain.Authority;
import com.newstar.hbms.system.service.AuthorityService;

import java.util.*;

/**
 * Created by fellowlong on 2016/10/21.
 */
public class AuthorityServiceImpl implements AuthorityService {

  private AuthorityDao authorityDao;

  public void setAuthorityDao(AuthorityDao authorityDao) {
    this.authorityDao = authorityDao;
  }

  @Override
  public int insert(Authority authority) {
    return 0;
  }

  @Override
  public int update(Authority authority) {
    return 0;
  }

  @Override
  public int deleteByIds(Long[] authorityIds) {
    return 0;
  }

  @Override
  public List<Authority> findAllTree() {
    List<Authority> authorities = authorityDao.findAll();
    if (authorities == null || authorities.isEmpty()) {
      return null;
    }
    //先转成Map
    SortedMap<Long, Authority> authorityMap = new TreeMap<Long, Authority>();
    for (Authority authority : authorities) {
      authorityMap.put(authority.getId(), authority);
    }
    //生成按模块的树结构
    for (Authority authority : authorityMap.values()) {
      if (authority.getParentId() != null) {
        authority.setParent(authorityMap.get(authority.getParentId()));
        authority.getParent().getChildren().add(authority);
      }
    }
    List<Authority> treeAuthorities = new ArrayList<Authority>();
    //生成按模块的树结构
    for (Authority authority : authorityMap.values()) {
      if (authority.getParentId() == null) {
        treeAuthorities.add(authority);
      }
    }
    return treeAuthorities;
  }

  @Override
  public List<Authority> findAll() {
    return authorityDao.findAll();
  }

  @Override
  public Authority findByUri(String uri) {
    return authorityDao.findByUri(uri);
  }

  @Override
  public List<Authority> findByIds(Long[] ids) {
    return null;
  }
}
