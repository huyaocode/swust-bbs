package com.team2.service.cmt;

import com.github.pagehelper.PageInfo;
import com.team2.pojo.base.BaseInfo;
import com.team2.pojo.cmt.Collection;
import com.team2.pojo.cmt.Information;
import com.team2.vo.cmt.CollectionQuery;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
public interface CollectionService {


   /**
    *根据id删除Collection
    */
	Long delById(Long id);

   /**
    *根据新增Collection，id自增
    */
    Long save(Collection record);

   /**
    *根据id查询Collection
    */
    Collection getById(Long id);
    
   /**
    *根据id更新Collection
    */ 
    Long editById(Collection record);

   /**
    *查询所有Collection
    */ 
    PageInfo<Collection> list(int pagenum, int pagesize,CollectionQuery param);

    List<Collection> listAll(CollectionQuery param);

	List<Information> getMyCollection();
}