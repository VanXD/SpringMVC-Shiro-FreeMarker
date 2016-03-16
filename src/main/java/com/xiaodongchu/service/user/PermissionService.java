package com.xiaodongchu.service.user;

import com.xiaodongchu.entity.user.Permission;

import java.util.List;


public interface PermissionService {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);

    List<Permission> findAll();
}
