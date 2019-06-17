package com.team2.dao.cmt;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.team2.pojo.cmt.HotSearch;
import com.team2.vo.cmt.HotSearchQuery;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface HotSearchDao {

   /**
      根据id删除HotSearch
   */
    int delById(Long id);
    
   /**
    *根据新增HotSearch,id自增
    */
    int save(HotSearch record);
    
    /**
     *根据id查询HotSearch
     */
    HotSearch getById(Long id);

    /**
     *根据id更新HotSearch
     */ 
    int editById(HotSearch record);

    /**
     *分页查询所有HotSearch
     */    
    List<HotSearch> list(HotSearchQuery param);
  
    @Select("select * from cmt_hot_search where hot_word =#{hotWord}")
    HotSearch getByHotWord(@Param("hotWord")String hotWord);
    
     
}