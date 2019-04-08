package com.nmys.story.service;

import com.nmys.story.model.bo.BackResponseBo;
import com.nmys.story.model.entity.Options;

import java.util.List;
import java.util.Map;

public interface IOptionService {

    /**
     * Description:根据名字查询配置
     * Author:hongfei.zhang
     * Param [name]
     * Return com.nmys.story.model.entity.Options
     */
    Options getOptionByName(String name);

    /**
     * Description:所有options
     * Author:hongfei.zhang
     * Param []
     * Return java.util.List<com.nmys.story.model.entity.Options>
     */
    List<Options> getOptions();

    /**
     * Description:保存或者更新设置
     * Author:hongfei.zhang
     * Param [querys]
     * Return void
     */
    void saveOrUpdateOptions(Map<String,String> options);

    void insertOption(String name, String value);

    /**
     * Description:备份数据库
     * Author:hongfei.zhang
     * Param [bk_type, bk_path, expression]
     * Return com.nmys.story.model.bo.BackResponseBo
     */
    BackResponseBo backup(String bk_type, String bk_path, String expression) throws Exception;
}
