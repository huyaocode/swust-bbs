package com.team2.dao.cmt;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.team2.pojo.cmt.Report;
import com.team2.vo.cmt.ReportQuery;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
@Mapper
public interface ReportDao {

   /**
      根据id删除Report
   */
    int delById(Long id);
    
    @Delete("delete from cmt_report where information_id=#{infoId}")
    int delByInfoId(@Param("infoId")Long infoId);
    
   /**
    *根据新增Report,id自增
    */
    int save(Report record);
    
    /**
     *根据id查询Report
     */
    Report getById(Long id);

    /**
     *根据id更新Report
     */ 
    int editById(Report record);

    /**
     *分页查询所有Report
     */    
    List<Report> list(ReportQuery param);

    @Update("update cmt_report set status='1' where id=#{id}")
	void setVerified(@Param("id")Long id);
      
}