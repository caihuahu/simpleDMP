package com.wzq.admin.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author wzq
 * @create 2023-02-14 21:39
 */
@Repository
public interface UserRoleDao {

    @Select("select `role_id` from `user_role` where `user_id` = #{userId}")
    Long getRoleIdByUserId(@Param("userId") Long userId);

    @Delete("delete from `user_role` where `user_id` = #{userId}")
    void deleteAllUserId(@Param("userId") Long userId);

    @Insert("insert into `user_role` (`user_id`,`role_id`) values (#{userId},#{roleId})")
    void addUserIdRoleIdRelationShip(@Param("userId") Long userId, @Param("roleId") Long roleId);
}
