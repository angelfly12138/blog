package com.nmys.story.mapper;

import com.nmys.story.model.entity.Metas;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MetaMapper {

    /**
     * Description: 根据类型来查询友链
     * author: hongfei.zhang
     */
    List<Metas> getMetasByType(@Param("type") String type);

    /**
     * Description:更新meta
     * Author:hongfei.zhang
     * Param [metas]
     * Return void
     */
    void updateMeta(Metas metas);

    /**
     * Description:新增meta
     * Author:hongfei.zhang
     * Param [metas]
     * Return void
     */
    void saveMeta(Metas metas);

    /**
     * Description:根据id删除meta
     * Author:hongfei.zhang
     * Param [id]
     * Return void
     */
    void delMetaById(@Param("id") Integer id);

    /**
     * Description:根据id来查询meta
     * Author:hongfei.zhang
     * Param [id]
     * Return com.nmys.story.model.entity.Metas
     */
    Metas getMetaById(@Param("id") Integer id);

    /**
     * Description:根据条件来查询meta
     * Author:hongfei.zhang
     * Param [type, name]
     * Return java.util.List<com.nmys.story.model.entity.Metas>
     */
    List<Metas> selectMetaListByConditions(@Param("type") String type, @Param("name") String name);

    /**
     * Description:meta和relationship的联合查询
     * Author:hongfei.zhang
     * Param [type]
     * Return java.util.List<com.nmys.story.model.entity.Metas>
     */
    List<Metas> getMetasBySql(@Param("type") String type);

    /**
     * Description:前台标签页使用
     * Author:hongfei.zhang
     * Param [type, name]
     * Return com.nmys.story.model.entity.Metas
     */
    Metas getMeta(@Param("type") String type, @Param("name") String name);

    /**
     * Description:查询标签下的文章数量
     * Author:hongfei.zhang
     * Param [mid]
     * Return int
     */
    int countWithSql(Integer mid);
}
