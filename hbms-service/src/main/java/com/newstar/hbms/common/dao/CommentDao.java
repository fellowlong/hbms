package com.newstar.hbms.common.dao;

import com.newstar.hbms.common.domain.Comment;
import com.newstar.hbms.utils.paging.PageRange;
import com.newstar.hbms.utils.paging.PagingResult;

import java.util.List;

/**
 * Created by wangjinsi on 2016/11/2.
 */
public interface CommentDao {
    
    public int insert(Comment comment);

    public int update(Comment comment);

    public int disable(Long[] commentIds);

    public int enable(Long[] commentIds);

    public PagingResult<Comment> findByBean(Comment comment, PageRange pageRange);

    public List<Comment> findByIds(Long[] ids);
}
