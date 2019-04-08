package com.nmys.story.model.entity;

import lombok.Data;

/**
 * description 用户角色类
 *
 * @author hongfei.zhang
 */

@Data
public class Role extends BaseEntity{

    private Integer id;

    /** 角色名称 **/
    private String name;

    /** 角色描述 **/
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
