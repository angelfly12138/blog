package com.nmys.story.model.entity;

import lombok.Data;

/**
 * Description:数据关系
 * Author:hongfei.zhang
 * Param
 * Return
 */
@Data
public class Relationships {

    // 内容主键
    private Integer cid;

    // 项目主键
    private Integer mid;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }
}