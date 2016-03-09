package com.xiaodongchu.service;

import com.xiaodongchu.dao.PermissionDao;
import com.xiaodongchu.dao.RoleDao;
import com.xiaodongchu.dao.UserDao;
import com.xiaodongchu.entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Service("permissionService")
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    public Permission createPermission(Permission permission) {
        permission.setAvailable(true);
        return permissionDao.createPermission(permission);
    }

    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }

    @Override
    public List<Permission> findAll() {
        return permissionDao.selectAll();
    }


}
