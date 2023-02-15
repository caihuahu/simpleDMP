package com.wzq.admin.controller;

import com.wzq.admin.bean.Permission;
import com.wzq.admin.service.PermissionService;
import com.wzq.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wzq
 * @create 2023-02-14 23:28
 */
@RestController
@RequestMapping("/admin/acl")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @GetMapping("/getAllPer")
    public R<List<Permission>> getAllPer() {
        return R.ok(permissionService.getAllPermissions());
    }

    @GetMapping("/getPerByUserId/{userId}")
    public R<List<String>> getPerByUserId(@PathVariable Long userId) {
        return R.ok(permissionService.getPermissionByUserId(userId));
    }

}
