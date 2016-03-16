package com.xiaodongchu.dao.user;

import com.xiaodongchu.entity.user.User;
import com.xiaodongchu.vo.page.Page;

import java.util.List;
import java.util.Set;


public interface UserDao {

    public User createUser(User user);
    public void updateUser(User user);
    public void deleteUser(Long userId);

    public int[] correlationRoles(Long userId, Long... roleIds);
    public void uncorrelationRoles(Long userId, Long... roleIds);

    User findOne(Long userId);

    User findByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);

    List<User> pageByExample(User userExample, Page page);
    public int[] correlationRoles(Long userId, String... roles);
}
