package com.wzq.admin.service.impl;

import com.wzq.admin.bean.User;
import com.wzq.admin.dao.UserDao;
import com.wzq.admin.service.RoleService;
import com.wzq.admin.service.UserRoleService;
import com.wzq.admin.service.UserService;
import com.wzq.admin.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wzq
 * @create 2023-02-13 21:44
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    RoleService roleService;

    @Autowired
    UserRoleService userRoleService;

    @Override
    public List<User> getAllUser() {
        List<User> allUser = userDao.getAllUser();
        // 为每个user设置角色名
        for (User user : allUser) {
            user.setRoleName(roleService.getUserRoleName(user.getId()));
        }

        return allUser;
    }

    @Override
    public User getUserByName(String username) {
        User user = userDao.getUserByName(username);
        user.setRoleName(roleService.getUserRoleName(user.getId()));
        return user;
    }

    @Override
    public User getUserById(Long userId) {
        User user = userDao.getUserById(userId);
        user.setRoleName(roleService.getUserRoleName(userId));
        return user;
    }

    @Override
    public void deleteUserById(Long userId) {
        // 删除user表该用户
        userDao.deleteUserById(userId);
        // 删除user_role表该用户
        userRoleService.deleteUserRoleRelationShipByUserId(userId);
    }

    @Override
    public void addUser(String username, String password) {
        // TODO 校验用户name的唯一性
        userDao.addUser(username, MD5.encrypt(password));
    }
}
