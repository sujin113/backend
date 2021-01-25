package com.codelifee.exercisecoach.exercisecoach.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.codelifee.exercisecoach.exercisecoach.model.Exercises;

@Mapper
public interface ExercisesMapper {

	@Select("select * from exercises order by exercise_sequence_id")
	List<Exercises> findAll();
	
	@Select("SELECT * FROM exercises WHERE exercise_sequence_id=#{exercise_sequence_id}")
	Exercises getExercises(@Param("exercise_sequence_id")int exercise_sequence_id);
	
	@Insert("INSERT INTO exercises(exercise_name,descriptions) VALUES(#{exercise_name},#{descriptions})")
	int insertExercises(@Param("exercise_name")String exer_name, @Param("descriptions")String descriptions);
	
	@Update("UPDATE exercises SET exercise_name=#{exercise_name},descriptions=#{descriptions} where exercise_sequence_id=#{exercise_sequence_id}")
	int updateExercises(@Param("exercise_sequence_id")int exercise_sequence_id, 
			@Param("exercise_name")String exercise_name, @Param("descriptions")String descriptions);
	
	@Delete("DELETE FROM exercises WHERE exercise_sequence_id=#{exercise_sequence_id}")
	int deleteExercises(@Param("exercise_sequence_id")int exercise_sequence_id);
	
}

