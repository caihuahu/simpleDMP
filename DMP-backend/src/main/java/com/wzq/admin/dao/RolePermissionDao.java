package com.wzq.admin.dao;

import com.wzq.admin.bean.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wzq
 * @create 2023-02-15 16:53
 */
@Repository
public interface RolePermissionDao {

    @Select("select permission_id from `role_permission` where `role_id` = #{roleId}")
    List<Long> getPermissionsByRoleId(@Param("roleId") Long roleId);

    @Delete("DELETE from role_permission where role_id = #{roleId}")
    void deleteRolePermissionShip(@Param("roleId") Long roleId);

    void addRolePermissionShip(@Param("roleId") Long roleId,@Param("list") List<Long> list);
}
