package com.nmys.story.mapper;

import com.nmys.story.model.entity.Relationships;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RelationshipMapper {

    /**
     * Description:根据mid来查询relationship
     * Author:hongfei.zhang
     * Param [mid]
     * Return java.util.List<com.nmys.story.model.entity.Relationships>
     */
    List<Relationships> getRelationshipByMid(@Param("mid") Integer mid);

    /**
     * Description:根据主键删除关系
     * Author:hongfei.zhang
     * Param [cid, mid]
     * Return void
     */
    void delRelationshipById(@Param("cid") Integer cid, @Param("mid") Integer mid);

    /**
     * Description: 保存关系
     * author: hongfei.zhang
     */
    void saveRelationship(Relationships relationships);

    /**
     * Description: 根据id查询关系是否存在
     * author: hongfei.zhang
     */
    Long countById(@Param("cid") Integer cid, @Param("mid") Integer mid);

    void delRelationshipByCId(@Param("cid") Integer cid);
}
