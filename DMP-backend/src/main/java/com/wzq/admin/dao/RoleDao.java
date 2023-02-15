package com.wzq.admin.dao;

import com.wzq.admin.bean.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wzq
 * @create 2023-02-14 21:24
 */
@Repository
public interface RoleDao {

    @Select("select id as id, role_name as roleName from `role`")
    List<Role> getAllRoles();

    @Delete("delete from `role` where `id` = #{id}")
    void deleteRoleById(@Param("id") Long roleId);

    @Insert("insert into `role` (`role_name`) values (#{role_name})")
    void addRole(@Param("role_name") String roleName);

    @Select("select `role_name` from `role` where role.id = (select `user_role`.`role_id` from `user_role` where `user_id` = #{userId})")
    String getUserRoleName(@Param("userId") Long userId);
}
