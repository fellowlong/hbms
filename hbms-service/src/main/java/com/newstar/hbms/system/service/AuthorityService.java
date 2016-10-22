package com.newstar.hbms.system.service;

import com.newstar.hbms.system.domain.Authority;

import java.util.List;

/**
 * Created by fellowlong on 2014-10-30.
 */
public interface AuthorityService {

  public int insert(Authority authority);

  public int update(Authority authority);

  public int deleteByIds(Long[] authorityIds);

  public List<Authority> findAllTree();

  public List<Authority> findAll();

  public Authority findByUri(String uri);

  public List<Authority> findByIds(Long[] ids);

}
