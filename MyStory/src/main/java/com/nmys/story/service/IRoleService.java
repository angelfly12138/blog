package com.nmys.story.service;

import com.nmys.story.model.entity.Role;

public interface IRoleService {

    /**
     * Description: 根据角色名称查找角色信息
     * Author:hongfei.zhang
     * Param [roleName]
     * Return Role
     */
    Role getRoleByRoleName(String roleName);

}
