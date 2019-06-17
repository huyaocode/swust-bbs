package com.team2.service.cmt;

import com.github.pagehelper.PageInfo;
import com.team2.pojo.base.SearchInfo;
import com.team2.pojo.cmt.HotSearch;
import com.team2.pojo.cmt.Information;
import com.team2.vo.cmt.HotSearchQuery;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
public interface HotSearchService {


   /**
    *根据id删除HotSearch
    */
	Long delById(Long id);

   /**
    *根据新增HotSearch，id自增
    */
    Long save(HotSearch record);

   /**
    *根据id查询HotSearch
    */
    HotSearch getById(Long id);
    
   /**
    *根据id更新HotSearch
    */ 
    Long editById(HotSearch record);

   /**
    *查询所有HotSearch
    */ 
    PageInfo<HotSearch> list(int pagenum, int pagesize,HotSearchQuery param);

    List<HotSearch> listAll(HotSearchQuery param);
    
    PageInfo<Information> doSearch(SearchInfo info);
}