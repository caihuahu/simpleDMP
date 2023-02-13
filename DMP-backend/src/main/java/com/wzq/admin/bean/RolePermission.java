package com.wzq.admin.bean;

/**
 * 角色-权限表
 * @author wzq
 * @create 2023-02-13 16:12
 */
public class RolePermission {

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 权限id的列表字符串
     */
    private String permissionIds;

    public RolePermission() {
    }


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(String permissionIds) {
        this.permissionIds = permissionIds;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "roleId=" + roleId +
                ", permissionIds='" + permissionIds + '\'' +
                '}';
    }
}
