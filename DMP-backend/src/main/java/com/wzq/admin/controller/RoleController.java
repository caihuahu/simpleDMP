package com.wzq.admin.controller;

import com.wzq.admin.bean.Permission;
import com.wzq.admin.bean.Role;
import com.wzq.admin.bean.RolePermission;
import com.wzq.admin.service.PermissionService;
import com.wzq.admin.service.RolePermissionService;
import com.wzq.admin.service.RoleService;
import com.wzq.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wzq
 * @create 2023-02-14 20:49
 */
@RestController
@RequestMapping("/admin/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @Autowired
    PermissionService permissionService;

    @Autowired
    RolePermissionService rolePermissionService;

    /**
     * 获取所有角色
     *
     * @return
     */
    @GetMapping("/getAllRoles")
    public R<List<Role>> getAllRoles() {
        return R.ok(roleService.getAllRoles());
    }

    /**
     * 根据角色Id删除角色
     *
     * @param roleId 角色Id
     * @return 返回是否删除成功
     */
    @DeleteMapping("/deleteRole/{roleId}")
    public R<String> deleteRoleByRoleId(@PathVariable Long roleId) {
        roleService.deleteRoleById(roleId);
        return R.ok("删除角色成功");
    }

    /**
     * 添加角色
     *
     * @param roleName 角色名称
     * @return 返回是否添加成功
     */
    @PostMapping("/addRole")
    public R<String> addRole(@RequestParam String roleName) {
        roleService.addRole(roleName);
        return R.ok("添加角色成功");
    }

    /**
     * 根据角色Id获取他的权限
     *
     * @param roleId 角色Id
     * @return 返回权限列表
     */
    @GetMapping("/permissions/{roleId}")
    public R<List<Permission>> getPermissionsByRoleId(@PathVariable Long roleId) {
        List<Permission> permissions = rolePermissionService.getPermissionsByRoleId(roleId);
        return R.ok(permissions);
    }

    /**
     * 为角色分配权限
     *
     * @param rolePermission
     * @return
     */
    @PostMapping("/assignPermissionsToRole")
    public R<String> assignPermissionsToRole(@RequestBody RolePermission rolePermission) {
        Long roleId = rolePermission.getRoleId();
        List<Long> list = Arrays.stream(rolePermission.getPermissionIds().split(","))
                .map(Long::parseLong)
                .collect(Collectors.toList());

        rolePermissionService.addRolePermissions(roleId,list);
        return R.ok("分配成功");
    }

}
