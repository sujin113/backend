package com.codelifee.exercisecoach.exercisecoach.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.codelifee.exercisecoach.exercisecoach.model.Administrator;

public interface AdministratorMapper {
	
	@Select("select * from administrator")
	Administrator getAdministrator();
	
	@Insert("INSERT INTO administrator VALUES(#{admin_id}, #{admin_pwd}, #{admin_name})")
	int insertAdministrator(@Param("admin_id")String admin_id, @Param("admin_pwd")String admin_pwd, 
			@Param("admin_name")String admin_name);
	
	@Update("UPDATE administrator SET admin_pwd=#{admin_pwd}, admin_name=#{admin_name} WHERE admin_id=#{admin_id}")
	int updateAdministrator(@Param("admin_id")String admin_id, @Param("admin_pwd")String admin_pwd, 
			@Param("admin_name")String admin_name);
	
	@Delete("DELETE FROM administrator WHERE admin_id=#{admin_id}")
	int deleteAdministrator(@Param("admin_id")String admin_id);
}
