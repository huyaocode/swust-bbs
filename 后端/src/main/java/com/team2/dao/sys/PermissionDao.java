package com.team2.dao.sys;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.team2.pojo.sys.Permission;
import com.team2.vo.sys.PermissionQuery;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PermissionDao {

   /**
      根据id删除Permission
   */
    int delById(Long id);
    
   /**
    *根据新增Permission,id自增
    */
    int save(Permission record);
    
    /**
     *根据id查询Permission
     */
    Permission getById(Long id);

    /**
     *根据id更新Permission
     */ 
    int editById(Permission record);

    /**
     *分页查询所有Permission
     */    
    List<Permission> list(PermissionQuery param);
    
    
     
}