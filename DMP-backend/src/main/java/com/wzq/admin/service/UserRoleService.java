package com.wzq.admin.service;

/**
 * @author wzq
 * @create 2023-02-14 21:36
 */
public interface UserRoleService {

    /**
     * 根据用户Id获取角色Id
     *
     * @param userId 用户Id
     * @return 返回该用户对应的角色Id
     */
    Long getRoleIdByUserId(Long userId);

    /**
     * 添加用户和角色的关系
     *
     * @param userId 用户Id
     * @param roleId 角色Id
     */
    void addUserIdRoleIdRelationShip(Long userId, Long roleId);

    /**
     * 删除角色
     * @param userId 用户id
     */
    void deleteUserRoleRelationShipByUserId(Long userId);
}
