package com.nmys.story.service;


import com.github.pagehelper.PageInfo;
import com.nmys.story.model.entity.Comments;

import java.util.List;

/**
 * Description:评论接口
 * Author:hongfei.zhang
 * Param
 * Return
 */
public interface ICommentService {

    /**
     * Description:查询评论的数量
     * Author:hongfei.zhang
     * Param []
     * Return int
     */
    int selectCommentCount();

    /**
     * Description:根据id来查询评论
     * Author:hongfei.zhang
     * Param [id]
     * Return com.nmys.story.model.entity.Comments
     */
    Comments selectCommentByid(Integer id);

    /**
     * Description:获取最新评论
     * Author:hongfei.zhang
     * Param [page, limit]
     * Return com.github.pagehelper.PageInfo<com.nmys.story.model.entity.Comments>
     */
    PageInfo<Comments> selectNewComments(Integer page, Integer limit);

//    List<Comments> selectNewComments(Integer page, Integer limit);

    /**
     * Description:保存评论
     * Author:hongfei.zhang
     * Param [comment]
     * Return int
     */
    int saveComments(Comments comment);

    /**
     * Description:根据id删除评论
     * Author:hongfei.zhang
     * Param [id]
     * Return String
     */
    String delCommentById(Integer id);

    /**
     * Description:查询非自己的评论
     * Author:hongfei.zhang
     * Param [authorId]
     * Return java.util.List<com.nmys.story.model.entity.Comments>
     */
    List<Comments> selectCommentsByAuthorId(Integer authorId);

    /**
     * Description:根据文章的id来获取改文章下面的评论
     * Author:hongfei.zhang
     * Param [contentId, page, limit]
     * Return com.github.pagehelper.PageInfo<com.nmys.story.model.entity.Comments>
     */
    PageInfo<Comments> getCommentsListByContentId(Integer contentId, Integer page, Integer limit);

    /**
     * Description:保存评论并返回结果
     * Author:hongfei.zhang
     * Param [comment]
     * Return java.lang.String
     */
    String insertComment(Comments comment);

    /**
     * Description:根据id来更新评论
     * Author:hongfei.zhang
     * Param [id]
     * Return void
     */
    void updateCommentById(Integer id);

    /**
     * Description:查询为审核的评论
     * Author:hongfei.zhang
     * Param []
     * Return java.util.List<com.nmys.story.model.entity.Comments>
     */
    List<Comments> getNotAuditComments();

    /**
     * Description: 更新评论
     * Author:hongfei.zhang
     * Param [comObj]
     * Return void
     */
    void updateComment(Comments comObj);
}
