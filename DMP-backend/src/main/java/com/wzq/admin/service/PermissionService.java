package com.wzq.admin.service;

import com.wzq.admin.bean.Permission;

import java.util.List;

/**
 * @author wzq
 * @create 2023-02-14 22:23
 */
public interface PermissionService {

    /**
     * 获取所有权限
     *
     * @return 返回权限组成的列表
     */
    List<Permission> getAllPermissions();

    /**
     * 根据用户Id获取用户对应的所有权限
     *
     * @param userId 用户id
     * @return 返回该用户对应的所有权限
     */
    List<String> getPermissionByUserId(Long userId);
}
