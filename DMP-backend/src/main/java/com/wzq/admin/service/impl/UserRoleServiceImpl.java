package com.wzq.admin.service.impl;

import com.wzq.admin.dao.UserRoleDao;
import com.wzq.admin.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wzq
 * @create 2023-02-14 21:38
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleDao userRoleDao;

    @Override
    public Long getRoleIdByUserId(Long userId) {
        return userRoleDao.getRoleIdByUserId(userId);
    }

    @Override
    public void addUserIdRoleIdRelationShip(Long userId, Long roleId) {
        // 删除原来userId关联的所有行
        userRoleDao.deleteAllUserId(userId);
        // 插入新的userId和roleId之间的关系
        userRoleDao.addUserIdRoleIdRelationShip(userId, roleId);
    }

    @Override
    public void deleteUserRoleRelationShipByUserId(Long userId) {
        userRoleDao.deleteAllUserId(userId);
    }
}
