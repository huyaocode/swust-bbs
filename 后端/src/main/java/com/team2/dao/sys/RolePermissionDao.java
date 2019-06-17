package com.team2.dao.sys;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.team2.pojo.sys.Permission;
import com.team2.pojo.sys.RolePermission;
import com.team2.vo.sys.RolePermissionQuery;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RolePermissionDao {

   /**
      根据id删除RolePermission
   */
    int delById(Long id);
    
   /**
    *根据新增RolePermission,id自增
    */
    int save(RolePermission record);
    
    /**
     *根据id查询RolePermission
     */
    RolePermission getById(Long id);

    /**
     *根据id更新RolePermission
     */ 
    int editById(RolePermission record);

    /**
     *分页查询所有RolePermission
     */    
    List<RolePermission> list(RolePermissionQuery param);
    
    List<Permission> listByRoleId(Long id);
    
    
     
}