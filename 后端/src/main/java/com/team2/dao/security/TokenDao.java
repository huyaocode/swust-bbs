package com.team2.dao.security;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.team2.pojo.security.TokenModel;
@Mapper
public interface TokenDao {
	
	@Insert("insert into sys_token(token,val, expire_time) values (#{token}, #{val}, #{expireTime})")
	int save(TokenModel model); 
	 
	TokenModel getById(Integer id);
	
	@Select("select * from sys_token  where token = #{token}")
	TokenModel getByToken(String token);

	@Update("update sys_token set val = #{val}, expire_time = #{expireTime} where token = #{token}")
	int update(TokenModel model);

	@Delete("delete from sys_token where token = #{token}")
	int delete(String token);
	
	@Update("update sys_token set token = #{token} where id = #{id}")
	int updateToken(@Param("id")Long id, @Param("token")String token);

}
