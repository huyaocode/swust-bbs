package com.team2.service.sys;

import com.github.pagehelper.PageInfo;
import com.team2.pojo.sys.Role;
import com.team2.vo.sys.RoleQuery;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
public interface RoleService {


   /**
    *根据id删除Role
    */
	Long delById(Long id);

   /**
    *根据新增Role，id自增
    */
    Long save(Role record);

   /**
    *根据id查询Role
    */
    Role getById(Long id);
    
   /**
    *根据id更新Role
    */ 
    Long editById(Role record);

   /**
    *查询所有Role
    */ 
    PageInfo<Role> list(int pagenum, int pagesize,RoleQuery param);

    List<Role> listAll(RoleQuery param);
}