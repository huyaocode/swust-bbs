package com.team2.dao.sys;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.team2.pojo.sys.Logs;
import com.team2.vo.sys.LogsQuery;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface LogsDao {

   /**
      根据id删除Logs
   */
    int delById(Long id);
    
   /**
    *根据新增Logs,id自增
    */
    int save(Logs record);
    
    /**
     *根据id查询Logs
     */
    Logs getById(Long id);

    /**
     *根据id更新Logs
     */ 
    int editById(Logs record);

    /**
     *分页查询所有Logs
     */    
    List<Logs> list(LogsQuery param);
    
   
}