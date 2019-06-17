package com.team2.dao.cmt;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.team2.pojo.cmt.Collection;
import com.team2.pojo.cmt.Information;
import com.team2.vo.cmt.CollectionQuery;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface CollectionDao {

   /**
      根据id删除Collection
   */
    int delById(Long id);
    
    @Delete("delete from cmt_collection where information_id=#{InfoId}")
    int delByInfoId(@Param("InfoId")Long InfoId);
    
   /**
    *根据新增Collection,id自增
    */
    int save(Collection record);
    
    /**
     *根据id查询Collection
     */
    Collection getById(Long id);

    /**
     *根据id更新Collection
     */ 
    int editById(Collection record);

    /**
     *分页查询所有Collection
     */    
    List<Collection> list(CollectionQuery param);

    @Select("select i.* from cmt_information i ,cmt_collection c "
    		+ "where c.user_id=#{userId} and c.information_id=i.id")
	List<Information> getCollection(@Param("userId")Long userId);

    @Select("select count(*) from cmt_collection where information_id=#{infoId} and user_id=#{userId}")
	int getCollectCount(@Param("infoId")Long infoId,@Param("userId")Long userId);
    
     
}