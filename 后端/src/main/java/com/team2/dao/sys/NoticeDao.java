package com.team2.dao.sys;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.team2.pojo.sys.Notice;
import com.team2.vo.sys.NoticeQuery;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface NoticeDao {

   /**
      根据id删除Notice
   */
    int delById(Long id);
    
   /**
    *根据新增Notice,id自增
    */
    int save(Notice record);
    
    /**
     *根据id查询Notice
     */
    Notice getById(Long id);

    /**
     *根据id更新Notice
     */ 
    int editById(Notice record);

    /**
     *分页查询所有Notice
     */    
    List<Notice> list(NoticeQuery param);
    
    
     
}