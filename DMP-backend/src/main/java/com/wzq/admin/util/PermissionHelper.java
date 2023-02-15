package com.wzq.admin.util;

import com.wzq.admin.bean.Permission;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author wzq
 * @create 2023-02-15 16:58
 */
public class PermissionHelper {

    public static ArrayList<Permission> build(List<Permission> permissions) {
        // 为所有的权限设置子权限列表
        ArrayList<Permission> result = new ArrayList<>();
        for (Permission permission : permissions) {
            if (permission.getParentId() == 0) {
                // 寻找子节点
                permission.setLevel(1);
                result.add(findChildren(permission, permissions));
            }
        }
        return result;
    }

    public static Permission findChildren(Permission permission, List<Permission> permissions) {
        // 设置子节点
        permission.setChildren(new ArrayList<>());

        for (Permission node : permissions) {
            if (Objects.equals(node.getParentId(), permission.getId())) {
                node.setLevel(permission.getLevel() + 1);
                if (permission.getChildren() == null) {
                    permission.setChildren(new ArrayList<>());
                }
                permission.getChildren().add(findChildren(node, permissions));
            }
        }
        return permission;
    }

}
