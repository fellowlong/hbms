package com.companyname.hbms.common.service.impl;

import com.companyname.hbms.common.Constants;
import com.companyname.hbms.common.dao.CommonDao;
import com.companyname.hbms.common.service.CommonService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
