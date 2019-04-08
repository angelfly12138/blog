package com.nmys.story.service;

import com.nmys.story.model.entity.Relationships;

import java.util.List;

public interface IRelationshipService {

    /**
     * Description:根据id搜索
     * Author:hongfei.zhang
     * Param [cid, mid]
     * Return java.util.List<com.nmys.story.model.entity.Relationships>
     */
    List<Relationships> getRelationshipById(Integer cid, Integer mid);

    /**
     * Description:根据id删除关系
     * Author:hongfei.zhang
     * Param [id]
     * Return void
     */
    void delRelationshipById(Integer cid, Integer mid);

    /**
     * Description: 保存关系
     * author: hongfei.zhang
     */
    void saveRelationship(Relationships relationships);

    /**
     * Description: 根据id来查询是否存在
     * author: hongfei.zhang
     */
    Long countById(Integer cid, int mid);

    void delRelationshipByCId(Integer cid);
}
