package com.team2.service.cmt;

import com.github.pagehelper.PageInfo;
import com.team2.pojo.base.ReportInfo;
import com.team2.pojo.cmt.Report;
import com.team2.vo.cmt.ReportQuery;
import java.util.List;
public interface ReportService {


   /**
    *根据id删除Report
    */
	Long delById(Long id);

   /**
    *根据新增Report，id自增
    */
    Long save(Report record);

   /**
    *根据id查询Report
    */
    Report getById(Long id);
    
   /**
    *根据id更新Report
    */ 
    Long editById(Report record);

   /**
    *查询所有Report
    */ 
    PageInfo<Report> list(int pagenum, int pagesize,ReportQuery param);

    List<Report> listAll(ReportQuery param);

	Long setBanned(ReportInfo recode);
}