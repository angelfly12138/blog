package com.nmys.story.service;

import com.nmys.story.model.entity.Metas;

import java.util.List;

/**
 * Description: 友情链接接口
 * author: hongfei.zhang
 */
public interface IMetaService {

    /**
     * Description: 根据类型来获取友链
     * author: hongfei.zhang
     */
    List<Metas> getMetasByType(String type);

    /**
     * Description:根据id删除meta
     * Author:hongfei.zhang
     * Param [id]
     * Return java.lang.String
     */
    void delMetaById(Integer id);

    /**
     * Description:根据id来获取meta
     * Author:hongfei.zhang
     * Param [id]
     * Return com.nmys.story.model.entity.Metas
     */
    Metas getMetaById(Integer id);

    /**
     * Description:保存项目
     * Author:hongfei.zhang
     * Param [type, cname, mid]
     * Return void
     */
    void saveMeta(String type, String cname, Integer mid);

    /**
     * Description:根据条件查metas
     * Author:hongfei.zhang
     * Param [type, orderby, limit]
     * Return java.util.List<com.nmys.story.model.entity.Metas>
     */
    List<Metas> getMetaList(String type, String orderby, Integer limit);

    /**
     * Description:前台标签页使用
     * Author:hongfei.zhang
     * Param [type, name]
     * Return com.nmys.story.model.entity.Metas
     */
    Metas getMeta(String type, String name);

    /**
     * Description: 保存分类或者标签
     * author: hongfei.zhang
     */
    void saveMetas(Integer cid, String tags, String type);
}
