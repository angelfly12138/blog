package com.nmys.story.service;

import com.github.pagehelper.PageInfo;
import com.nmys.story.model.entity.Contents;

import java.util.List;

/**
 * Description:文章内容接口
 * Author:hongfei.zhang
 * Param
 * Return
 */
public interface IContentService {

    /**
     * Description:根据类型获取文章列表
     * Author:hongfei.zhang
     * Param [type]
     * Return java.util.List<com.nmys.story.model.entity.Contents>
     */
    List<Contents> getContentsByType(String type, String status);

    /**
     * Description:博客前台文章分页查询
     * Author:hongfei.zhang
     * Param [page, limit]
     * Return java.util.List<com.nmys.story.model.entity.Contents>
     */
    PageInfo<Contents> getContentsByPageInfo(Integer page, Integer limit);

    /**
     * Description:更新文章内容
     * Author:hongfei.zhang
     * Param [content]
     * Description:根据id来获取文章详情
     * Return boolean
     */
    boolean updateContent(Contents content);

    /**
     * Author:hongfei.zhang
     * Param [id]
     * Return com.nmys.story.model.entity.Contents
     */
    Contents getContentById(Integer id);

    /**
     * Description: 根据文章缩略名来查询文章
     * author: hongfei.zhang
     */
    Contents getContentBySlug(String slug);

    /**
     * Description: 根据特定条件来查询文章
     * author: hongfei.zhang
     */
    PageInfo<Contents> getContentsConditions(String type, Integer page, Integer limit);

    /**
     * Description: 保存文章
     * author: hongfei.zhang
     */
    String saveContent(Contents content);

    /**
     * Description:
     * Author:hongfei.zhang
     * Param [page, limit]
     * Return com.github.pagehelper.PageInfo<com.nmys.story.model.entity.Contents>
     */
    PageInfo<Contents> getArticlesWithpage(Integer page, Integer limit);


    /**
     * Description:根据id删除文章
     * Author:hongfei.zhang
     * Param [id]
     * Return java.lang.String
     */
    String delContentById(Integer id);


    /**
     * Description:查询标签下面的所属文章
     * Author:hongfei.zhang
     * Param [mid, page, limit] meta的id
     * Return com.github.pagehelper.PageInfo<com.nmys.story.model.entity.Contents>
     */
    PageInfo<Contents> getTagArticles(Integer mid, int page, int limit);

    /**
     * Description: 根据title来搜索文章
     * Author:hongfei.zhang
     * Param [title, page, limit]
     * Return com.github.pagehelper.PageInfo<com.nmys.story.model.entity.Contents>
     */
    PageInfo<Contents> searchContentByTitle(String title, int page, int limit);

    /**
     * Description: 修改文章标签关系表
     * Author:hongfei.zhang
     * Param [cid, tags, categories] 本篇文章的id，文章的标签字符串数组，文章的分类
     */
    void updateRelationsShips(Integer cid, String tags, String categories);

    PageInfo<Contents> getArticlesByConditions(String article, String tag, String status, int page, int limit);

    /**
     * Description: 查询文章数量
     * @author: hongfei.zhang
     */
    int getContentCount();
}
