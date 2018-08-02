/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/31 15:40
 **/
package com.wip.service.comment.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wip.constant.ErrorConstant;
import com.wip.dao.CommentDao;
import com.wip.dto.cond.CommentCond;
import com.wip.exception.BusinessException;
import com.wip.model.CommentDomain;
import com.wip.model.ContentDomain;
import com.wip.service.article.ContentService;
import com.wip.service.comment.CommentService;
import com.wip.utils.DateKit;
import com.wip.utils.TaleUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private ContentService contentService;

    private static final Map<String,String> STATUS_MAP = new ConcurrentHashMap<>();

    /**
     * 评论状态：正常
     */
    private static final String STATUS_NORMAL = "approved";
    /**
     * 评论状态：不不显示
     */
    private static final String STATUS_BLANK = "not_audit";

    static {
        STATUS_MAP.put("approved",STATUS_NORMAL);
        STATUS_MAP.put("not_audit",STATUS_BLANK);
    }


    @Override
    @Transactional
    @CacheEvict(value = "commentCache", allEntries = true)
    public void addComment(CommentDomain comments) {
        String msg = null;

        if (null == comments) {
            msg = "评论对象为空";
        }

        if (StringUtils.isBlank(comments.getAuthor())) {
            comments.setAuthor("热心网友");
        }
        if (StringUtils.isNotBlank(comments.getEmail()) && !TaleUtils.isEmail(comments.getEmail())) {
            msg =  "请输入正确的邮箱格式";
        }
        if (StringUtils.isBlank(comments.getContent())) {
            msg = "评论内容不能为空";
        }
        if (comments.getContent().length() < 5 || comments.getContent().length() > 2000) {
            msg = "评论字数在5-2000个字符";
        }
        if (null == comments.getCid()) {
            msg = "评论文章不能为空";
        }
        if (msg != null)
            throw BusinessException.withErrorCode(msg);

        ContentDomain article = contentService.getArticleById(comments.getCid());
        if (null == article) {
            throw BusinessException.withErrorCode("该文章不存在");
        }

        comments.setOwnerId(article.getAuthorId());
        comments.setStatus(STATUS_MAP.get(STATUS_BLANK));
        comments.setCreated(DateKit.getCurrentUnixTime());
        commentDao.addComment(comments);

        ContentDomain temp = new ContentDomain();
        temp.setCid(article.getCid());
        Integer count = article.getCommentsNum();
        if (null == count) {
            count = 0;
        }
        temp.setCommentsNum(count + 1);
        contentService.updateContentByCid(temp);

    }

    @Override
    @Cacheable(value = "commentCache", key = "'commentsByCId_' + #p0")
    public List<CommentDomain> getCommentsByCId(Integer cid) {
        if (null == cid)
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        return commentDao.getCommentByCId(cid);
    }

    @Override
    @Cacheable(value = "commentCache", key = "'commentsByCond_'+ #p1")
    public PageInfo<CommentDomain> getCommentsByCond(CommentCond commentCond, int pageNum, int pageSize) {
        if (null == commentCond)
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        PageHelper.startPage(pageNum,pageSize);
        List<CommentDomain> comments = commentDao.getCommentsByCond(commentCond);
        PageInfo<CommentDomain> pageInfo = new PageInfo<>(comments);
        return pageInfo;
    }

    @Override
    @Cacheable(value = "commentCache",key = "'commentById_' + #p0")
    public CommentDomain getCommentById(Integer coid) {
        if (null == coid)
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        return commentDao.getCommentById(coid);
    }

    @Override
    @CacheEvict(value = "commentCache", allEntries = true)
    public void updateCommentStatus(Integer coid, String status) {
        if (null == coid)
            throw BusinessException.withErrorCode(ErrorConstant.Common.PARAM_IS_EMPTY);
        commentDao.updateCommentStatus(coid, status);
    }
}
