package com.nmys.story.service;

import com.nmys.story.model.entity.Users;

/**
 * @author hongfei.zhang
 * @Title: IUserService
 * @Description: user接口
 */
public interface IUserService {

    /**
     * Description: 用户的登录接口
     * author: hongfei.zhang
     */
    Users userLogin(String username, String password);

    /**
     * Description: 保存user
     * author: hongfei.zhang
     */
    void saveUser(Users user);

    /**
     * Description: 根据用户名来查询用户
     * author: hongfei.zhang
     */
    Users selectUserByUsername(String username);

    /**
     * Description: 更新用户信息
     * author: hongfei.zhang
     */
    boolean updateUser(Users user);

    /**
     * Description: 根据id来查询用户
     * author: hongfei.zhang
     */
    Users selectUserById(Integer id);

}
