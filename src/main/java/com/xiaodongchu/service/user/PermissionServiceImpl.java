package com.xiaodongchu.service.user;

import com.xiaodongchu.dao.user.PermissionDao;
import com.xiaodongchu.dao.user.RoleDao;
import com.xiaodongchu.dao.user.UserDao;
import com.xiaodongchu.entity.user.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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
