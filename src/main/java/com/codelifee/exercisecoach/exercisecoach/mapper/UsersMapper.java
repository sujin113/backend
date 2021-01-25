package com.codelifee.exercisecoach.exercisecoach.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.codelifee.exercisecoach.exercisecoach.model.Users;

@Mapper
public interface UsersMapper {

	@Select("select * from users order by user_id")
	List<Users> findAll();
	
	@Select("SELECT * FROM users WHERE user_id=#{user_id}")
	Users getUsers(@Param("user_id")String user_id);
	
	@Insert("INSERT INTO users VALUES(#{user_id},#{user_pwd},#{user_name},"
			+ "#{user_year},#{user_month},#{user_day},#{user_email},#{user_mobile},now())")
	int insertUsers(@Param("user_id")String user_id, @Param("user_pwd")String user_pwd, 
			@Param("user_name")String user_name, @Param("user_year")int user_year, 
			@Param("user_month")int user_month, @Param("user_day")int user_day, 
			@Param("user_email") String user_email, @Param("user_mobile") String user_mobile);
	
	@Update("UPDATE users SET user_pwd=#{user_pwd},user_name=#{user_name},user_year=#{user_year},"
			+ "user_month=#{user_month},user_day=#{user_day},user_email=#{user_email},user_mobile=#{user_mobile}"
			+ "WHERE user_id=#{user_id}")
	int updateUsers(@Param("user_id")String user_id, @Param("user_pwd")String user_pwd, 
			@Param("user_name")String user_name, @Param("user_year")int user_year, 
			@Param("user_month")int user_month, @Param("user_day")int user_day, 
			@Param("user_email") String user_email, @Param("user_mobile") String user_mobile);
	
	@Delete("DELETE FROM users WHERE user_id=#{user_id}")
	int deleteUsers(@Param("user_id")String user_id);
	
}
