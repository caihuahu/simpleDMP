package com.wzq.admin.bean;

/**
 * 和角色表进行一定的对应
 *
 * @author wzq
 * @create 2023-02-13 16:03
 */
public class Role {

    /**
     * 主键Id
     */
    private Long id;

    /**
     * 角色名
     */
    private String roleName;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
