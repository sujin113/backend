package com.codelifee.exercisecoach.exercisecoach.model;

public class Comments {
	
	private int comment_sequence_id;
	private String contents;
	private String comment_regdate;
	private String user_sequence_id;
	private String exercise_sequence_id;
	
	public int getComment_sequence_id() {
		return comment_sequence_id;
	}
	public void setComment_sequence_id(int comment_sequence_id) {
		this.comment_sequence_id = comment_sequence_id;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getComment_regdate() {
		return comment_regdate;
	}
	public void setComment_regdate(String comment_regdate) {
		this.comment_regdate = comment_regdate;
	}
	public String getUser_sequence_id() {
		return user_sequence_id;
	}
	public void setUser_sequence_id(String user_sequence_id) {
		this.user_sequence_id = user_sequence_id;
	}
	public String getExercise_sequence_id() {
		return exercise_sequence_id;
	}
	public void setExercise_sequence_id(String exercise_sequence_id) {
		this.exercise_sequence_id = exercise_sequence_id;
	}	
}
