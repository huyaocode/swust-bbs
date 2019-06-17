package com.team2.dao.cmt;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.team2.pojo.cmt.Category;
import com.team2.vo.cmt.CategoryQuery;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CategoryDao {

   /**
      根据id删除Category
   */
    int delById(Long id);
    
   /**
    *根据新增Category,id自增
    */
    int save(Category record);
    
    /**
     *根据id查询Category
     */
    Category getById(Long id);

    /**
     *根据id更新Category
     */ 
    int editById(Category record);

    /**
     *分页查询所有Category
     */    
    List<Category> list(CategoryQuery param);
    
   
     
}