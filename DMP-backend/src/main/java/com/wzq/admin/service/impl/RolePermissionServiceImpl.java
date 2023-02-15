package com.wzq.admin.service.impl;

import com.wzq.admin.bean.Permission;
import com.wzq.admin.dao.PermissionDao;
import com.wzq.admin.dao.RolePermissionDao;
import com.wzq.admin.service.RolePermissionService;
import com.wzq.admin.util.PermissionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wzq
 * @create 2023-02-15 16:47
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    RolePermissionDao rolePermissionDao;

    @Autowired
    PermissionDao permissionDao;

    @Override
    public List<Permission> getPermissionsByRoleId(Long roleId) {
        // 获取该角色拥有的权限
        List<Long> permissions = rolePermissionDao.getPermissionsByRoleId(roleId);

        // 获取所有权限
        List<Permission> allPermissions = permissionDao.getAllPermissions();

        // 将该角色拥有的权限设置为true
        for (Permission per : allPermissions) {
            if (permissions.contains(per.getId())) {
                per.setSelect(true);
            }
        }

        // 建立权限的父子关系
        ArrayList<Permission> result = PermissionHelper.build(allPermissions);
        return result;
    }

    @Override
    public void addRolePermissions(Long roleId, List<Long> list) {
        // 先删除原有的关系
        rolePermissionDao.deleteRolePermissionShip(roleId);

        // 建立现在的联系，动态SQL
        rolePermissionDao.addRolePermissionShip(roleId, list);
    }
}
