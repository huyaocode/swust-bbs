package com.team2.service.cmt;

import com.github.pagehelper.PageInfo;
import com.team2.pojo.cmt.Category;
import com.team2.vo.cmt.CategoryQuery;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
public interface CategoryService {


   /**
    *根据id删除Category
    */
	Long delById(Long id);

   /**
    *根据新增Category，id自增
    */
    Long save(Category record);

   /**
    *根据id查询Category
    */
    Category getById(Long id);
    
   /**
    *根据id更新Category
    */ 
    Long editById(Category record);

   /**
    *查询所有Category
    */ 
    PageInfo<Category> list(int pagenum, int pagesize,CategoryQuery param);

    List<Category> listAll(CategoryQuery param);
}