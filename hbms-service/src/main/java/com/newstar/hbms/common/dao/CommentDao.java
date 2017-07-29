package com.newstar.hbms.common.dao;

import com.newstar.hbms.common.domain.Comment;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.util.List;

/**
 * Created by wangjinsi on 2016/11/2.
 */
public interface CommentDao {
    
    public int insert(Comment comment);

    public int update(Comment comment);

    public int disableByIds(Long[] commentIds);

    public int disableByBusiness(String businessType, Long businessId);

    public PagingResult<Comment> findByBean(Comment comment, PageRange pageRange);

    public List<Comment> findByIds(Long[] ids);

    public List<Comment> findByBusiness(String businessType, Long[] businessIds);
}
