package com.codelifee.exercisecoach.exercisecoach.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.codelifee.exercisecoach.exercisecoach.model.User_Exercise;

public interface User_ExerciseMapper {

	@Select("select * from user_exercise order by user_sequence_id")
	List<User_Exercise> findAll();
	
	@Select("SELECT * FROM user_exercise WHERE user_sequence_id=#{user_sequence_id}")
	User_Exercise getUsers(@Param("user_sequence_id")int user_sequence_id);
	

}
