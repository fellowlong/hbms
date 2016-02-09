package com.newstar.hbms.common.service.impl;

import com.newstar.hbms.common.dao.CommonDao;
import com.newstar.hbms.common.service.CommonService;

import java.util.Date;

/**
 * Created by fellowlong on 2014-09-28.
 */
public class CommonServiceImpl implements CommonService {

  private CommonDao commonDao;

  public void setCommonDao(CommonDao commonDao) {
    this.commonDao = commonDao;
  }

  @Override
  public Date getCurrentDate() {
    return commonDao.getCurrentDate();
  }



}
