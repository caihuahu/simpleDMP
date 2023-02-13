package com.wzq.admin.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户登录信息
 *
 * @author wzq
 * @create 2023-02-13 16:14
 */
public class UserLoginInfo {

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户可以访问的路由组成的集合
     */
    private Set<String> routes = new HashSet<>();

    public UserLoginInfo() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getRoutes() {
        return routes;
    }

    public void setRoutes(Set<String> routes) {
        this.routes = routes;
    }

    @Override
    public String toString() {
        return "UserLoginInfo{" +
                "username='" + username + '\'' +
                ", routes=" + routes +
                '}';
    }
}
