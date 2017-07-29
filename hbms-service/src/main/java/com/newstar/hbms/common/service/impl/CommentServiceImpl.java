package com.newstar.hbms.common.service.impl;

import com.newstar.hbms.common.dao.CommentDao;
import com.newstar.hbms.common.domain.Comment;
import com.newstar.hbms.common.service.CommentService;
import com.newstar.hbms.support.paging.PageRange;
import com.newstar.hbms.support.paging.PagingResult;

import java.util.List;

/**
 * Created by wangjinsi on 2017-07-29.
 */
public class CommentServiceImpl implements CommentService {

    private CommentDao commentDao;

    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public int insert(Comment comment) {
        return commentDao.insert(comment);
    }

    @Override
    public int disableByIds(Long[] commentIds) {
        return commentDao.disableByIds(commentIds);
    }

    @Override
    public int disableByBusiness(String businessType, Long businessId) {
        return commentDao.disableByBusiness(businessType, businessId);
    }

    @Override
    public List<Comment> findByIds(Long[] commentIds) {
        return commentDao.findByIds(commentIds);
    }

    @Override
    public PagingResult<Comment> findByBean(Comment comment, PageRange pageRange) {
        return commentDao.findByBean(comment, pageRange);
    }

    @Override
    public List<Comment> findByBusiness(String businessType, Long[] businessIds) {
        return commentDao.findByBusiness(businessType, businessIds);
    }
}
