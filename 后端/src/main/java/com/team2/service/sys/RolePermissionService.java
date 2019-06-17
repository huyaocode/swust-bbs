package com.team2.service.sys;

import com.github.pagehelper.PageInfo;
import com.team2.pojo.sys.Permission;
import com.team2.pojo.sys.RolePermission;
import com.team2.vo.sys.RolePermissionQuery;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
public interface RolePermissionService {


   /**
    *根据id删除RolePermission
    */
	Long delById(Long id);

   /**
    *根据新增RolePermission，id自增
    */
    Long save(RolePermission record);

   /**
    *根据id查询RolePermission
    */
    RolePermission getById(Long id);
    
    List<Permission>listByRoleId(Long id);
    
   /**
    *根据id更新RolePermission
    */ 
    Long editById(RolePermission record);

   /**
    *查询所有RolePermission
    */ 
    PageInfo<RolePermission> list(int pagenum, int pagesize,RolePermissionQuery param);

    List<RolePermission> listAll(RolePermissionQuery param);
}