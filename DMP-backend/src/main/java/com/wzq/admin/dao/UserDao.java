package com.wzq.admin.dao;

import com.wzq.admin.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wzq
 * @create 2023-02-13 21:32
 */
@Repository
public interface UserDao {

    @Select("select * from `user`")
    List<User> getAllUser();

    @Select("select * from `user` where `username` = #{username}")
    User getUserByName(@Param("username") String username);

    @Insert("INSERT INTO `user` (`username`,`password`) VALUES (#{username},#{password});")
    void addUser(@Param("username") String username, @Param("password") String password);

    @Delete("delete from `user` where `id` = #{id}")
    void deleteUserById(@Param("id") Long userId);

    @Select("select * from `user` where id = #{userId}")
    User getUserById(@Param("userId") Long userId);
}
