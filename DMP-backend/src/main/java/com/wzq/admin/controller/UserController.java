package com.wzq.admin.controller;

import com.wzq.admin.bean.User;
import com.wzq.admin.service.UserService;
import com.wzq.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wzq
 * @create 2023-02-13 21:46
 */
@RestController
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/getAllUsers")
    public R<List<User>> getAllUsers() {
        List<User> allUser = userService.getAllUser();
        return R.of(200, "success", allUser);
    }

}
