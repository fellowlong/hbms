package com.newstar.hbms.system.dao;

import com.newstar.hbms.system.domain.Authority;

import java.util.List;

/**
 * Created by fellowlong on 2014-10-30.
 */
public interface AuthorityDao {

  public int insert(Authority authority);

  public int update(Authority authority);

  public int deleteByIds(Long[] authorityIds);

  public List<Authority> findAll();

  public Authority findByUri(String uri);

  public List<Authority> findByIds(Long[] ids);

}
