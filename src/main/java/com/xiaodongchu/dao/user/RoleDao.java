package com.xiaodongchu.dao.user;

import com.xiaodongchu.entity.user.Role;

import java.util.List;


public interface RoleDao {

    public Role createRole(Role role);
    public void deleteRole(Long roleId);

    public void correlationPermissions(Long roleId, Long... permissionIds);
    public void uncorrelationPermissions(Long roleId, Long... permissionIds);

    public List<Role> selectAll();

    List<Role> selectByUserId(Long userId);
}
