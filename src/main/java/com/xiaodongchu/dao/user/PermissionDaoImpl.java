package com.xiaodongchu.dao.user;

import com.xiaodongchu.dao.JdbcDaoSupportAbstract;
import com.xiaodongchu.entity.user.Permission;
import com.xiaodongchu.entity.user.User;
import com.xiaodongchu.vo.page.Page;
import com.xiaodongchu.vo.page.vo.user.UserRoleVO;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Repository("permissionDao")
public class PermissionDaoImpl extends JdbcDaoSupportAbstract implements PermissionDao {

    public Permission createPermission(final Permission permission) {
        final String sql = "insert into sys_permissions(permission, description, available) values(?,?,?)";

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        getJdbcTemplate().update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst = connection.prepareStatement(sql, new String[]{"id"});
                psst.setString(1, permission.getPermission());
                psst.setString(2, permission.getDescription());
                psst.setBoolean(3, permission.getAvailable());
                return psst;
            }
        }, keyHolder);
        permission.setId(keyHolder.getKey().longValue());

        return permission;
    }

    public void deletePermission(Long permissionId) {
        //首先把与permission关联的相关表的数据删掉
        String sql = "delete from sys_roles_permissions where permission_id=?";
        getJdbcTemplate().update(sql, permissionId);

        sql = "delete from sys_permissions where id=?";
        getJdbcTemplate().update(sql, permissionId);
    }

    @Override
    public List<UserRoleVO> pageByExample(User userExample, Permission permissionExample, Page page) {
        StringBuilder sql = new StringBuilder("SELECT su.id userId, su.username, su.password, su.salt, su.locked, sr.role, sr.description roleDescription" +
                " FROM sys_users su LEFT JOIN sys_users_roles sur ON su.id = sur.user_id LEFT JOIN sys_roles sr ON sur.role_id = sr.id" +
                " WHERE sr.available = 1");
        StringBuilder orderSQL = new StringBuilder("");
        List<Object> params = new LinkedList<>();
        if(page != null) {
            setPageParams(page, sql.toString(), orderSQL, params);
        }
        try {
            return getJdbcTemplate().query(sql.append(orderSQL).toString(), params.toArray(), BeanPropertyRowMapper.newInstance(UserRoleVO.class));
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Permission> selectAll() {
        String sql = "SELECT id, permission, description, available FROM sys_permissions";
        return getJdbcTemplate().query(sql, BeanPropertyRowMapper.newInstance(Permission.class));
    }

}
