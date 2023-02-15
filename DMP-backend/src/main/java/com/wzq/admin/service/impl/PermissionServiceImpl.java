package com.wzq.admin.service.impl;

import com.wzq.admin.bean.Permission;
import com.wzq.admin.dao.PermissionDao;
import com.wzq.admin.service.PermissionService;
import com.wzq.admin.util.PermissionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author wzq
 * @create 2023-02-14 22:24
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionDao permissionDao;

    @Override
    public List<Permission> getAllPermissions() {
        List<Permission> permissions = permissionDao.getAllPermissions();
        ArrayList<Permission> result = PermissionHelper.build(permissions);
        return result;
    }


    @Override
    public List<String> getPermissionByUserId(Long userId) {

        List<String> res = permissionDao.getPermissionByUserId(userId);

        return res;
    }
}
