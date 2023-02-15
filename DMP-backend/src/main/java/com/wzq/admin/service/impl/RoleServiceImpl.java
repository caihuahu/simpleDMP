package com.wzq.admin.service.impl;

import com.wzq.admin.bean.Role;
import com.wzq.admin.dao.RoleDao;
import com.wzq.admin.service.RolePermissionService;
import com.wzq.admin.service.RoleService;
import com.wzq.admin.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wzq
 * @create 2023-02-14 21:23
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Autowired
    UserRoleService userRoleService;

    @Autowired
    RolePermissionService rolePermissionService;

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public String getUserRoleName(Long userId) {
        return roleDao.getUserRoleName(userId);
    }

    @Override
    public void deleteRoleById(Long roleId) {
        // 删除Role表该角色
        roleDao.deleteRoleById(roleId);
        // 删除user_role表该角色
        // 删除role_permission表该角色
    }

    @Override
    public void addRole(String roleName) {
        roleDao.addRole(roleName);
    }
}
