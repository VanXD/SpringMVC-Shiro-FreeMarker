package com.xiaodongchu.vo.user;

import com.xiaodongchu.entity.user.Role;

import java.util.List;

/**
 * Created by Administrator on 2016/3/8.
 */
public class UserRoleVO {
    private Long userId;
    private String username;
    private List<Role> roles;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
