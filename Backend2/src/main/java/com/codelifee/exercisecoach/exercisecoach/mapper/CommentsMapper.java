package com.codelifee.exercisecoach.exercisecoach.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.codelifee.exercisecoach.exercisecoach.model.Comments;

public interface CommentsMapper {

	@Select("select * from comments order by comment_sequence_id")
	List<Comments> findAll();
	
	@Select("SELECT * FROM comments WHERE comment_sequence_id=#{comment_sequence_id}")
	Comments getComments(@Param("comment_sequence_id")int comment_sequence_id);
	
	@Insert("INSERT INTO comments(contents,user_sequence_id,exercise_sequence_id) VALUES(#{contents},#{user_sequence_id},#{exercise_sequence_id})")
	int insertComments(@Param("contents")String contents, @Param("user_sequence_id")int user_sequence_id, 
			@Param("exercise_sequence_id")int exercise_sequence_id);
	
	@Update("UPDATE comments SET contents=#{contents} where comment_sequence_id=#{comment_sequence_id}")
	int updateComments(@Param("contents")String contents,@Param("comment_sequence_id")int comment_sequence_id);
	
	@Delete("DELETE FROM comments WHERE comment_sequence_id=#{comment_sequence_id}")
	int deleteComments(@Param("comment_sequence_id")int comment_sequence_id);
}
