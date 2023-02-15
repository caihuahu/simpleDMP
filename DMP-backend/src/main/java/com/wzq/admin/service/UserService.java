package com.wzq.admin.service;

import com.wzq.admin.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wzq
 * @create 2023-02-13 21:43
 */
public interface UserService {

    /**
     * 获取所有用户
     *
     * @return 返回所用用户组成的List
     */
    List<User> getAllUser();

    /**
     * 通过Name获取User
     *
     * @param username 用户name
     * @return 返回一个User实体类
     */
    User getUserByName(String username);

    /**
     * 根据Id获取User
     *
     * @param userId 用户Id
     * @return User实体类
     */
    User getUserById(Long userId);

    /**
     * 根据用户Id删除用户
     *
     * @param userId userId
     */
    void deleteUserById(Long userId);

    /**
     * 添加新用户
     *
     * @param username 用户名
     * @param password 未经过加密的密码
     */
    void addUser(String username, String password);
}
