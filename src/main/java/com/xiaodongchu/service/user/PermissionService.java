package com.xiaodongchu.service.user;

import com.xiaodongchu.entity.user.Permission;

import java.util.List;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface PermissionService {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);

    List<Permission> findAll();
}
