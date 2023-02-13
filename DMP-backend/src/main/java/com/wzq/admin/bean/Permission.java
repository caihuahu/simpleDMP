package com.wzq.admin.bean;

import java.util.List;

/**
 * 和权限表表进行一定的对应
 *
 * @author wzq
 * @create 2023-02-13 16:05
 */
public class Permission {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 上级权限的Id
     */
    private Long parentId;

    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 权限的编码（前端组件url的名字）
     */
    private String permissionCode;

    /**
     * 表示权限的层级
     */
    private Integer level;

    /**
     * 权限的子权限组成的列表
     */
    private List<Permission> children;

    /**
     * 供前端使用，权限是否被选中
     */
    private Boolean select = false;

    public Permission() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<Permission> getChildren() {
        return children;
    }

    public void setChildren(List<Permission> children) {
        this.children = children;
    }

    public Boolean getSelect() {
        return select;
    }

    public void setSelect(Boolean select) {
        this.select = select;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", permissionName='" + permissionName + '\'' +
                ", permissionCode='" + permissionCode + '\'' +
                ", level=" + level +
                ", children=" + children +
                ", select=" + select +
                '}';
    }
}
