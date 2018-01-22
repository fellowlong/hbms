package com.newstar.hbms.common.dao;

import com.newstar.hbms.common.domain.Attachment;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.util.List;

/**
 * Created by fellowlong on 2016/11/2.
 */
public interface AttachmentDao {
    
    public int insert(Attachment attachment);

    public int update(Attachment attachment);

    public int deleteByIds(Long[] attachmentIds);

    public int deleteByBusiness(String businessType, Long businessId);

    public List<Attachment> findByIds(Long[] attachmentIds);

    public List<Attachment> findByBean(Attachment attachment);

    public List<Attachment> findByBusiness(String businessType, Long[] businessIds);

}
