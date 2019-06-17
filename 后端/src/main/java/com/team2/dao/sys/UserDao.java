package com.team2.dao.sys;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.team2.pojo.base.UserInfo;
import com.team2.pojo.sys.LoginUser;
import com.team2.pojo.sys.Role;
import com.team2.pojo.sys.User;
import com.team2.vo.sys.UserQuery;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.scripting.xmltags.WhereSqlNode;
@Mapper
public interface UserDao {

   /**
      根据id删除User
   */
    int delById(Long id);
    
   /**
    *根据新增User,id自增
    */
    int save(User record);
    

    @Update("update sys_user set password=#{password} where id=#{id}")
    int editPassword(@Param("password")String password,@Param("id")Long id);
    
    /**
     *根据id查询User
     */
    User getById(Long id);

    /**
     *根据id更新User
     */ 
    int editById(User record);

    /**
     *分页查询所有User
     */    
    List<User> list(UserQuery param);
    
    @Select("select * from sys_user where username=#{username}")
    User getByUsername(@Param("username") String username); 
   
    @Update("update sys_user set head_img_url=#{headImgUrl} where id =#{id}")
    int setHeadImg(@Param("headImgUrl")String headImgUrl,@Param("id")Long id);
    
    @Update("update sys_user set status='0' where id=#{id}")
    int lockUser(@Param("id")Long id);

    @Update("update sys_user set status='1' where id=#{id}")
    int unlockUser(@Param("id")Long id);
    
    @Select("select count(*) from sys_user")
    long getUserCount();
}