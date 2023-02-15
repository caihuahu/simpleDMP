package com.wzq.admin.service;

import com.wzq.admin.bean.Role;

import java.util.List;

/**
 * @author wzq
 * @create 2023-02-14 21:20
 */
public interface RoleService {

    /**
     * 获取所有角色
     *
     * @return 返回Role组成的List
     */
    List<Role> getAllRoles();

    /**
     * 根据用户Id获取对应的角色名称
     *
     * @param userId 用户Id
     * @return 返回该用户对应的角色名
     */
    String getUserRoleName(Long userId);

    /**
     * 根据角色Id删除Role
     *
     * @param roleId 角色id
     */
    void deleteRoleById(Long roleId);

    /**
     * 新增一个角色
     *
     * @param roleName 角色名称
     */
    void addRole(String roleName);
}
