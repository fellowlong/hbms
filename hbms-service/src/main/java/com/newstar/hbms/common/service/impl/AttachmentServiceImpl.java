package com.newstar.hbms.common.service.impl;

import com.newstar.hbms.common.dao.AttachmentDao;
import com.newstar.hbms.common.domain.Attachment;
import com.newstar.hbms.common.service.AttachmentService;

import java.util.List;

/**
 * Created by wangjinsi on 17-1-18.
 */
public class AttachmentServiceImpl implements AttachmentService {

  public static final String BUSINESS_TYPE_RESUME = "resume";
  public static final String BUSINESS_TYPE_CANDIDATE = "candidate";
  public static final String BUSINESS_TYPE_COMPANY = "company";

  private AttachmentDao attachmentDao;

  public void setAttachmentDao(AttachmentDao attachmentDao) {
    this.attachmentDao = attachmentDao;
  }

  @Override
  public int insert(Attachment attachment) {
    return attachmentDao.insert(attachment);
  }

  @Override
  public int deleteByIds(Long[] attachmentIds) {
    return attachmentDao.deleteByIds(attachmentIds);
  }

  @Override
  public int deleteByBusiness(String businessType, Long businessId) {
    return attachmentDao.deleteByBusiness(businessType, businessId);
  }

  @Override
  public List<Attachment> findByBusiness(String businessType, Long[] businessIds) {
    return attachmentDao.findByBusiness(businessType, businessIds);
  }
}
