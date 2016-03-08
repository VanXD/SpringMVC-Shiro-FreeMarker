package com.xiaodongchu.dao;

import com.xiaodongchu.entity.Permission;
import com.xiaodongchu.entity.User;
import com.xiaodongchu.vo.page.Page;
import com.xiaodongchu.vo.page.vo.user.UserRoleVO;

import java.util.List;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface PermissionDao {

    public Permission createPermission(Permission permission);

    public void deletePermission(Long permissionId);

    List<UserRoleVO> pageByExample(User userExample, Permission permissionExample, Page page);

    List<Permission> selectAll();
}
