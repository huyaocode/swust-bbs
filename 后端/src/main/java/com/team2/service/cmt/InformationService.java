package com.team2.service.cmt;

import com.github.pagehelper.PageInfo;
import com.team2.pojo.base.BaseInfo;
import com.team2.pojo.base.CountInfo;
import com.team2.pojo.cmt.Information;
import com.team2.vo.cmt.InformationQuery;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
public interface InformationService {


   /**
    *根据id删除Information
    */
	Long delById(Long id);

   /**
    *根据新增Information，id自增
    */
    Long save(Information record);

   /**
    *根据id查询Information
    */
    Information getById(Long id);
    
   /**
    *根据id更新Information
    */ 
    Long editById(Information record);

   /**
    *查询所有Information
    */ 
    PageInfo<Information> list(int pagenum, int pagesize,InformationQuery param);
    
    /**
      *查询所有Information+分类
     */ 
     PageInfo<Information> listDetail(int pagenum, int pagesize,InformationQuery param);

    List<Information> listAll(InformationQuery param);

	List<Information> getMyInfo(BaseInfo info);

    Long setResolved(Long id);

    Long setBanned(Long id);

	CountInfo getCountInfo();
}