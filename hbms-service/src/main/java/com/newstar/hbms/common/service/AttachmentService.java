package com.newstar.hbms.common.service;

import com.newstar.hbms.common.domain.Attachment;

import java.util.List;

/**
 * Created by wangjinsi on 17-1-18.
 */
public interface AttachmentService {

  public int insert(Attachment attachment);

  public int deleteByIds(Long[] attachmentIds);

  public int deleteByBusiness(String businessType, Long businessId);

  public List<Attachment> findByBusiness(String businessType, Long businessId);

}
