package com.nmys.story.model.entity;

import lombok.Data;

/**
 * description 用户权限类
 *
 * @author hongfei.zhang
 */

@Data
public class Permission extends BaseEntity {

    private Integer id;

    /** url地址 **/
    private String url;

    /** url描述 **/
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
