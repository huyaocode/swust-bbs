package com.team2.service.sys;

import com.github.pagehelper.PageInfo;
import com.team2.pojo.sys.Notice;
import com.team2.vo.sys.NoticeQuery;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
public interface NoticeService {


   /**
    *根据id删除Notice
    */
	Long delById(Long id);

   /**
    *根据新增Notice，id自增
    */
    Long save(Notice record);

   /**
    *根据id查询Notice
    */
    Notice getById(Long id);
    
   /**
    *根据id更新Notice
    */ 
    Long editById(Notice record);

   /**
    *查询所有Notice
    */ 
    PageInfo<Notice> list(int pagenum, int pagesize,NoticeQuery param);

    List<Notice> listAll(NoticeQuery param);
}