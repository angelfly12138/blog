package com.nmys.story.service;

public interface IUserRoleService {

    /**
     * Description: 为用户添加角色
     * Author:hongfei.zhang
     * Param [roleName]
     * Return Role
     */
    void addRoleForUser(String userId, String roleId);

}
