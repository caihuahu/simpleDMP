package com.wzq.admin.dao;

import com.wzq.admin.bean.Permission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wzq
 * @create 2023-02-14 22:25
 */
@Repository
public interface PermissionDao {

    @Select("select id, parent_id as parentId, permission_name as permissionName, permission_code as permissionCode from permission")
    List<Permission> getAllPermissions();

    List<String> getPermissionByUserId(@Param("userId") Long userId);
}
