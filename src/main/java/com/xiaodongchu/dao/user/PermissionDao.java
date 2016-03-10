package com.xiaodongchu.dao.user;

import com.xiaodongchu.entity.user.Permission;
import com.xiaodongchu.entity.user.User;
import com.xiaodongchu.vo.page.Page;
import com.xiaodongchu.vo.user.UserRoleVO;

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
