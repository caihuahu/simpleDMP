package com.wzq.admin.service;

import com.wzq.admin.bean.Permission;

import java.util.List;

/**
 * @author wzq
 * @create 2023-02-15 16:47
 */
public interface RolePermissionService {

    /**
     * 根据角色Id获取他的权限
     *
     * @param roleId 角色Id
     * @return 返回所有权限
     */
    List<Permission> getPermissionsByRoleId(Long roleId);

    /**
     * 为角色分配权限
     * @param roleId 角色id
     * @param list 权限列表
     */
    void addRolePermissions(Long roleId, List<Long> list);
}
