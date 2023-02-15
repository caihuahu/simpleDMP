package com.wzq.admin.controller;

import com.wzq.admin.bean.User;
import com.wzq.admin.bean.UserLoginInfo;
import com.wzq.admin.service.IndexService;
import com.wzq.admin.service.UserService;
import com.wzq.admin.util.JwtHelper;
import com.wzq.admin.util.MD5;
import com.wzq.util.R;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author wzq
 * @create 2023-02-14 20:55
 */
@RestController
@RequestMapping("/admin/index")
public class IndexController {

    @Autowired
    UserService userService;

    @Autowired
    IndexService indexService;

    /**
     * 登录API
     *
     * @param userInfo 用户信息，{username,password}
     * @return 返回登录成功或失败
     */
    @PostMapping("/login")
    public R<String> login(@RequestBody User userInfo) {
        // 根据用户名查找该用户是否存在
        User user = userService.getUserByName(userInfo.getUsername());

        if (user != null) {
            String encrypt = MD5.encrypt(userInfo.getPassword());

            if (Objects.equals(encrypt, user.getPassword())) {
                // 创建该用户的JWT token
                String token = JwtHelper.createToken(user.getId(), user.getUsername());
                return R.ok(token);
            } else {
                return R.error("登陆失败！用户名或密码错误");
            }
        } else {
            return R.error("用户【" + userInfo.getUsername() + "】不存在");
        }
    }

    @GetMapping("/userInfo")
    public R<UserLoginInfo> userInfo(HttpServletRequest request) {
        String token = request.getHeader("token");
        Long userId = JwtHelper.getUserId(token);
        String userName = JwtHelper.getUserName(token);

        // 获取用户登录信息
        UserLoginInfo userInfo = indexService.getUserInfo(userId, userName);
        if (userInfo != null) {
            return R.ok(userInfo);
        }
        return R.error("用户不存在");
    }

    @PostMapping("logout")
    public R<Void> logout() {
        return R.ok(null);
    }

}
