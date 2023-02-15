package com.wzq.admin.controller;

import com.wzq.admin.bean.User;
import com.wzq.admin.bean.UserRole;
import com.wzq.admin.dao.UserRoleDao;
import com.wzq.admin.service.UserRoleService;
import com.wzq.admin.service.UserService;
import com.wzq.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    UserRoleService userRoleService;

    /**
     * 获取所有用户
     *
     * @return 返回所有用户
     */
    @GetMapping("/getAllUsers")
    public R<List<User>> getAllUsers() {
        return R.ok(userService.getAllUser());
    }

    /**
     * 新增一个用户
     *
     * @param userInfo 用户信息
     * @return 返回成功或失败
     */
    @PostMapping("/addUser")
    public R<String> addUser(@RequestBody User userInfo) {
        userService.addUser(userInfo.getUsername(), userInfo.getPassword());
        return R.ok("新添加了用户：【" + userInfo.getUsername() + "】");
    }

    @PostMapping("/assignRoleToUser")
    public R<String> assignRoleToUser(@RequestBody UserRole userRole) {
        userRoleService.addUserIdRoleIdRelationShip(userRole.getUserId(), userRole.getRoleId());
        return R.ok("分配角色成功");
    }

    /**
     * 根据用户id获取用户
     *
     * @param userId 用户Id
     * @return 返回Id对应的用户
     */
    @GetMapping("/getUser/{userId}")
    public R<User> getUserById(@PathVariable Long userId) {
        return R.ok(userService.getUserById(userId));
    }

//    @PostMapping("/save")
//    public R<String> saveRole(@RequestBody Role role) {
//        return R.ok();
//    }

    /**
     * 根据Id删除一个用户
     *
     * @param userId 用户Id
     * @return 返回是否删除成功
     */
    @DeleteMapping("/deleteUser/{userId}")
    public R<String> deleteUserById(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return R.ok("删除id为：【" + userId + "】的用户");
    }

//    /**
//     * @param adminId
//     * @return
//     */
//    @GetMapping("/toAssign/{adminId}")
//    public R<User> getRoles(@PathVariable Long adminId) {
//        return R.error();
//    }

    /**
     * @param adminId
     * @return
     */
    @GetMapping("/getRoleIdByUserId/{adminId}")
    public R<Long> getRoleIdByAdminId(@PathVariable Long adminId) {
        return R.ok(userRoleService.getRoleIdByUserId(adminId));
    }

//    @PostMapping("/assignRoleToUser")
//    public R<String> assignRoleToUser(@RequestBody UserRole userRole) {
//        userRoleService.addUserIdRoleIdRelationShip(userRole.getUserId(), userRole.getRoleId());
//        return R.ok("分配角色成功");
//    }


}
