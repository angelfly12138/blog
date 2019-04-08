package com.nmys.story.mapper;

import com.nmys.story.model.entity.Permission;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * description
 *
 * @author hongfei.zhang
 */

@Component
public interface UserPermissionMapper {

    List<Permission> findByUserName(String userName);

}
