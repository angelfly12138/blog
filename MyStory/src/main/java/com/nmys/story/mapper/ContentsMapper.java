package com.nmys.story.mapper;

import com.nmys.story.model.dto.Archive;
import com.nmys.story.model.entity.Contents;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ContentsMapper {

    /**
     * Description:根据类型查询最新发布的文章
     * Author:hongfei.zhang
     * Param [Type]
     * Return java.util.List<com.nmys.story.model.entity.Contents>
     */
    List<Contents> getContentsByType(@Param("type") String type, @Param("status") String status);

    /**
     * Description:更新文章
     * Author:hongfei.zhang
     * Param [content]
     * Return boolean
     */
    boolean updateContent(Contents content);

    /**
     * Description:根据id获取文章
     * Author:hongfei.zhang
     * Param [id]
     * Return com.nmys.story.model.entity.Contents
     */
    Contents getContentById(@Param("id") Integer id);

    /**
     * Description: 查询归档文章
     * author: hongfei.zhang
     */
    List<Archive> selectArchive();

    /**
     * Description: 查询文章by特定条件
     * author: hongfei.zhang
     */
    List<Contents> getContentsByConditions(@Param("type") String type, @Param("status") String status, @Param("startTime") Integer startTime, @Param("endTime") Integer endTime);

    /**
     * Description: 根据文章缩略名来查询文章
     * author: hongfei.zhang
     */
    Contents getContentBySlug(@Param("slug") String slug);

    /**
     * Description: 根据特定条件来查询文章列表
     * author: hongfei.zhang
     */
    List<Contents> getContentsConditions(@Param("type") String type, @Param("userId") Integer userId);

    /**
     * Description: 保存文章
     * author: hongfei.zhang
     */
    void saveContent(Contents content);

    /**
     * Description: 根据条件查询文章的个数
     * author: hongfei.zhang
     */
    long selectContentByConditions(@Param("type") String type, @Param("slug") String slug);

    /**
     * Description:根据id删除文章
     * Author:hongfei.zhang
     * Param [id]
     * Return void
     */
    void delContentById(@Param("id") Integer id);

    /**
     * Description:根据mid来查询标签下的所有文章
     * Author:hongfei.zhang
     * Param [mid]
     * Return java.util.List<com.nmys.story.model.entity.Contents>
     */
    List<Contents> getContentsListByMetaId(@Param("mid") Integer mid);

    List<Contents> searchContentByTitle(@Param("title") String title, @Param("type") String type, @Param("status") String publish);

    List<Contents> getarticlesByConditions(@Param("type") String type, @Param("tag") String tag, @Param("status") String status, @Param("userId") Integer userId);

    int getContentCount();
}
