package com.nmys.story.mapper;

import com.nmys.story.model.entity.Comments;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentMapper {

    /**
     * Description:评论总数
     * Author:hongfei.zhang
     * Param []
     * Return int
     */
    int selectCommentCount();

    /**
     * Description:根据id来查询评论内容
     * Author:hongfei.zhang
     * Param [id]
     * Return com.nmys.story.model.entity.Comments
     */
    Comments selectCommentByid(@Param("id") Integer id);

    /**
     * Description:查询最新评论
     * Author:hongfei.zhang
     * Param []
     * Return java.util.List<com.nmys.story.model.entity.Comments>
     */
    List<Comments> selectNewComments();

    /**
     * Description:新增评论
     * Author:hongfei.zhang
     * Param [comment]
     * Return int
     */
    int saveComment(Comments comment);

    /**
     * Description:根据id删除评论
     * Author:hongfei.zhang
     * Param [id]
     * Return boolean
     */
    boolean delCommentById(@Param("id") Integer id);

    /**
     * Description:查询非己评论
     * Author:hongfei.zhang
     * Param [authorId]
     * Return java.util.List<com.nmys.story.model.entity.Comments>
     */
    List<Comments> selectCommentsByAuthorId(@Param("authorId") Integer authorId);

    /**
     * Description:根据文章的id来获取改文章下面的评论
     * Author:hongfei.zhang
     * Param [cid, parentId, status]
     * Return java.util.List<com.nmys.story.model.entity.Comments>
     */
    List<Comments> getCommentsListByContentId(@Param("cid") Integer cid, @Param("status") String status);

    /**
     * Description:查询未审核评论
     * Author:hongfei.zhang
     * Param []
     * Return java.util.List<com.nmys.story.model.entity.Comments>
     */
    List<Comments> getNotAuditComments();

    void updateCommentById(@Param("id") Integer id);

    void updateComment(Comments comObj);

}
