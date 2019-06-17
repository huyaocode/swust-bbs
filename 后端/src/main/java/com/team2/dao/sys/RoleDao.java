package com.team2.dao.sys;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.team2.pojo.sys.Role;
import com.team2.vo.sys.RoleQuery;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RoleDao {

   /**
      根据id删除Role
   */
    int delById(Long id);
    
   /**
    *根据新增Role,id自增
    */
    int save(Role record);
    
    /**
     *根据id查询Role
     */
    Role getById(Long id);

    /**
     *根据id更新Role
     */ 
    int editById(Role record);

    /**
     *分页查询所有Role
     */    
    List<Role> list(RoleQuery param);
    
   
     
}