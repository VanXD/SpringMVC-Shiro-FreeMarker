package com.xiaodongchu.dao;

import com.xiaodongchu.entity.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Repository("roleDao")
public class RoleDaoImpl extends JdbcDaoSupportAbstract implements RoleDao {

    public Role createRole(final Role Role) {
        final String sql = "insert into sys_roles(role, description, available) values(?,?,?)";

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        getJdbcTemplate().update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst = connection.prepareStatement(sql, new String[]{"id"});
                psst.setString(1, Role.getRole());
                psst.setString(2, Role.getDescription());
                psst.setBoolean(3, Role.getAvailable());
                return psst;
            }
        }, keyHolder);
        Role.setId(keyHolder.getKey().longValue());

        return Role;
    }

    public void deleteRole(Long roleId) {
        //首先把和role关联的相关表数据删掉
        String sql = "delete from sys_users_roles where role_id=?";
        getJdbcTemplate().update(sql, roleId);

        sql = "delete from sys_roles where id=?";
        getJdbcTemplate().update(sql, roleId);
    }

    @Override
    public void correlationPermissions(Long roleId, Long... permissionIds) {
        if(permissionIds == null || permissionIds.length == 0) {
            return;
        }
        String sql = "insert into sys_roles_permissions(role_id, permission_id) values(?,?)";
        for(Long permissionId : permissionIds) {
            if(!exists(roleId, permissionId)) {
                getJdbcTemplate().update(sql, roleId, permissionId);
            }
        }
    }


    @Override
    public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
        if(permissionIds == null || permissionIds.length == 0) {
            return;
        }
        String sql = "delete from sys_roles_permissions where role_id=? and permission_id=?";
        for(Long permissionId : permissionIds) {
            if(exists(roleId, permissionId)) {
                getJdbcTemplate().update(sql, roleId, permissionId);
            }
        }
    }

    @Override
    public List<Role> selectAll() {
        String sql = "SELECT id, role, description, available FROM sys_roles WHERE available = 1";
        return getJdbcTemplate().query(sql, BeanPropertyRowMapper.newInstance(Role.class));
    }

    @Override
    public List<Role> selectByUserId(Long userId) {
        StringBuilder sql = new StringBuilder("SELECT sr.id, sr.role, sr.description, sr.available FROM sys_users su LEFT JOIN sys_users_roles sur ON su.id = sur.user_id LEFT JOIN sys_roles sr ON sr.id = sur.role_id WHERE su.id = ?");
        return getJdbcTemplate().query(sql.toString(), new Object[]{userId}, BeanPropertyRowMapper.newInstance(Role.class));
    }

    private boolean exists(Long roleId, Long permissionId) {
        String sql = "select count(1) from sys_roles_permissions where role_id=? and permission_id=?";
        return getJdbcTemplate().queryForObject(sql, Integer.class, roleId, permissionId) != 0;
    }

}
