package com.wzq.admin.service;

import com.wzq.admin.bean.UserLoginInfo;

/**
 * @author wzq
 * @create 2023-02-15 16:23
 */
public interface IndexService {

    /**
     * 获取用户登录信息
     * @param userId 用户Id
     * @param userName 用户名
     * @return UserLoginInfo
     */
    UserLoginInfo getUserInfo(Long userId, String userName);

}
