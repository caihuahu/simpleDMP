package com.wzq.admin.service;

import com.wzq.admin.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wzq
 * @create 2023-02-13 21:43
 */
public interface UserService {

    List<User> getAllUser();

}
