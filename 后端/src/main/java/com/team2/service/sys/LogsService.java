package com.team2.service.sys;

import com.github.pagehelper.PageInfo;
import com.team2.pojo.sys.Logs;
import com.team2.vo.sys.LogsQuery;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
public interface LogsService {


   /**
    *根据id删除Logs
    */
	Long delById(Long id);

   /**
    *根据新增Logs，id自增
    */
    Long save(Logs record);

   /**
    *根据id查询Logs
    */
    Logs getById(Long id);
    
   /**
    *根据id更新Logs
    */ 
    Long editById(Logs record);

   /**
    *查询所有Logs
    */ 
    PageInfo<Logs> list(int pagenum, int pagesize,LogsQuery param);

    List<Logs> listAll(LogsQuery param);
}