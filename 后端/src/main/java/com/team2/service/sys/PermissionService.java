package com.team2.service.sys;

import com.github.pagehelper.PageInfo;
import com.team2.pojo.sys.Permission;
import com.team2.vo.sys.PermissionQuery;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
public interface PermissionService {


   /**
    *根据id删除Permission
    */
	Long delById(Long id);

   /**
    *根据新增Permission，id自增
    */
    Long save(Permission record);

   /**
    *根据id查询Permission
    */
    Permission getById(Long id);
    
   /**
    *根据id更新Permission
    */ 
    Long editById(Permission record);

   /**
    *查询所有Permission
    */ 
    PageInfo<Permission> list(int pagenum, int pagesize,PermissionQuery param);

    List<Permission> listAll(PermissionQuery param);
}