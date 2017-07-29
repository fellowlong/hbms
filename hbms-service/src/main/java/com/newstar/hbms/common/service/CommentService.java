package com.newstar.hbms.common.service;

import com.newstar.hbms.common.domain.Comment;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.util.List;

/**
 * Created by wangjinsi on 17-1-18.
 */
public interface CommentService {

  public int insert(Comment comment);

  public int disableByIds(Long[] commentIds);

  public int disableByBusiness(String businessType, Long businessId);

  public List<Comment> findByIds(Long[] commentIds);

  public PagingResult<Comment> findByBean(Comment comment, PageRange pageRange);

  public List<Comment> findByBusiness(String businessType, Long[] businessIds);

}
