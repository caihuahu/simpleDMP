package com.wzq.admin.service.impl;

import com.wzq.admin.bean.User;
import com.wzq.admin.bean.UserLoginInfo;
import com.wzq.admin.service.IndexService;
import com.wzq.admin.service.PermissionService;
import com.wzq.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wzq
 * @create 2023-02-15 16:24
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    PermissionService permissionService;

    @Autowired
    UserService userService;

    @Override
    public UserLoginInfo getUserInfo(Long userId, String userName) {
        User user = userService.getUserById(userId);
        if (user != null) {
            UserLoginInfo userLoginInfo = new UserLoginInfo();
            userLoginInfo.setUsername(userName);

            List<String> userRoutes = permissionService.getPermissionByUserId(userId);
            userLoginInfo.getRoutes().addAll(userRoutes);
            return userLoginInfo;
        }
        return null;
    }
}
