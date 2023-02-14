package com.wzq.admin.dao;

import com.wzq.admin.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wzq
 * @create 2023-02-13 21:32
 */
@Repository
public interface UserDao {
    List<User> getAllUser();
}
