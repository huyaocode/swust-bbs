package com.team2.dao.cmt;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.team2.pojo.cmt.Information;
import com.team2.vo.cmt.InformationQuery;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
@Mapper
public interface InformationDao {

   /**
      根据id删除Information
   */
    int delById(Long id);
    
   /**
    *根据新增Information,id自增
    */
    int save(Information record);
    
    /**
     *根据id查询Information
     */
    Information getById(Long id);

    /**
     *根据id更新Information
     */ 
    int editById(Information record);

    /**
     *分页查询所有Information
     */    
    List<Information> list(InformationQuery param);
    
    /**
       *分页查询所有Information加分类详情
     */    
    List<Information> listAll(InformationQuery param);
    
    @Select("select * from cmt_information where type=#{type} and user_id=#{userId}")
    List<Information> getMyInfo(@Param("type")String type,@Param("userId")Long userId);

    @Update("update cmt_information set status='1' where id=#{id}")
	void setResolved(@Param("id")Long id);

    @Update("update cmt_information set status='2' where id=#{id}")
	void setBanned(@Param("id")Long informationId);
    
    @Select("select count(*) from cmt_information")
    long getInfoCount();
}