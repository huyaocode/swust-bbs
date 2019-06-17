package com.team2.service.sys;

import com.github.pagehelper.PageInfo;
import com.team2.pojo.base.LoginInfo;
import com.team2.pojo.base.UserInfo;
import com.team2.pojo.sys.User;
import com.team2.vo.sys.UserQuery;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;
public interface UserService {


   /**
    *根据id删除User
    */
	Long delById(Long id);

   /**
    *根据新增User，id自增
    */
    Long save(User record);

    /**
     *根据token查询User
     */
    User getUser();

    /**
     *根据id查询User
     */
    User getUserById(Long id);
    
   /**
    *根据id更新User
    */ 
    Long editById(User record);
    
    String editPassword(UserInfo record);

   /**
    *查询所有User
    */ 
    PageInfo<User> list(int pagenum, int pagesize,UserQuery param);

    List<User> listAll(UserQuery param);

	User getByUsername(String tel);
	
	int setHeadImg(String headUrl,Long id);

    Long lockUser(Long id);

    Long unlockUser(Long id);

}