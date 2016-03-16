package com.xiaodongchu.service.user;

import com.xiaodongchu.dao.user.RoleDao;
import com.xiaodongchu.dao.user.UserDao;
import com.xiaodongchu.entity.user.Role;
import com.xiaodongchu.entity.user.User;
import com.xiaodongchu.service.PasswordHelper;
import com.xiaodongchu.vo.page.Page;
import com.xiaodongchu.vo.user.UserRoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordHelper passwordHelper;

    /**
     * 创建用户
     * @param user
     */
    public User createUser(User user) {
        //加密密码
        passwordHelper.encryptPassword(user);
        User saveUser = userDao.createUser(user);
        correlationRoles(saveUser.getId(), "customer");
        return saveUser;
    }

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword) {
        User user =userDao.findOne(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userDao.updateUser(user);
    }

    /**
     * 添加用户-角色关系
     * @param userId
     * @param roleIds
     */
    public int[] correlationRoles(Long userId, Long... roleIds) {
        return userDao.correlationRoles(userId, roleIds);
    }

    /**
     * 添加用户-角色关系
     * @param userId
     * @param roles
     */
    public int[] correlationRoles(Long userId, String... roles) {
        return userDao.correlationRoles(userId, roles);
    }

    /**
     * 移除用户-角色关系
     * @param userId
     * @param roleIds
     */
    public void uncorrelationRoles(Long userId, Long... roleIds) {
        userDao.uncorrelationRoles(userId, roleIds);
    }

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String username) {
        return userDao.findRoles(username);
    }

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username) {
        return userDao.findPermissions(username);
    }

    @Override
    public List<UserRoleVO> roleList(User userExample, Page page) {
        List<User> users = userDao.pageByExample(userExample, page);
        List<UserRoleVO> userRoleVOList = new LinkedList<>();
        UserRoleVO userRoleVO = null;
        for(User user : users) {
            List<Role> roles = roleDao.selectByUserId(user.getId());
            userRoleVO = new UserRoleVO();
            userRoleVO.setUserId(user.getId());
            userRoleVO.setUsername(user.getUsername());
            userRoleVO.setRoles(roles);
            userRoleVOList.add(userRoleVO);
        }
        return userRoleVOList;
    }
}
