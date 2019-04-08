package com.nmys.story.mapper;

import com.nmys.story.model.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * description
 *
 * @author hongfei.zhang
 */

@Component
public interface UserRoleMapper {

    List<Role> findByUserName(String userName);

    void addRoleForUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
