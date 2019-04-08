package com.nmys.story.mapper;

import com.nmys.story.model.entity.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Description: user mapper
 * author: hongfei.zhang
 */

@Component
public interface UserMapper {

    Users getUserByUserNameAndPassword(@Param("username") String username, @Param("password") String password);

    Users selectUserByUsername(@Param("username") String username);

    void saveUser(Users user);

    boolean updateUser(Users user);

    /**
     * Description: 根据id来查询用户
     * author: hongfei.zhang
     */
    Users selectUserById(@Param("id") Integer id);

}
