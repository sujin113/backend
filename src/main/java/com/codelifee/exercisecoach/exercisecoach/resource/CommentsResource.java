package com.codelifee.exercisecoach.exercisecoach.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codelifee.exercisecoach.exercisecoach.mapper.CommentsMapper;
import com.codelifee.exercisecoach.exercisecoach.model.Comments;

@RestController
@RequestMapping("/rest/comments")
@CrossOrigin(origins="http://localhost:5000")
public class CommentsResource {

	private CommentsMapper commentsMapper;
	
	@Autowired
	public CommentsResource(CommentsMapper commentsMapper) {
		this.commentsMapper = commentsMapper;
	}
	
	@GetMapping("/all")
	public List<Comments> getAll() {
		return commentsMapper.findAll();
	}
	
	@GetMapping("/{comment_sequence_id}")
	public Comments getComments(@PathVariable("comment_sequence_id")int comment_sequence_id) {
		return commentsMapper.getComments(comment_sequence_id);
	}
	
	@PutMapping("/create_comment")
	public void createComments(@RequestParam("contents")String contents, @RequestParam("user_sequence_id")int user_sequence_id, 
			@RequestParam("exercise_sequence_id")int exercise_sequence_id) {
		commentsMapper.insertComments(contents, user_sequence_id, exercise_sequence_id);
	}
	
	@PostMapping("/{comment_sequence_id}")
	public void updateComments(@PathVariable("comment_sequence_id")int comment_sequence_id, @RequestParam("contents")String contents) {
		commentsMapper.updateComments(contents, comment_sequence_id);
	}
	
	@DeleteMapping("/{comment_sequence_id}")
	public void deleteComments(@PathVariable("comment_sequence_id")int comment_sequence_id) {
		commentsMapper.deleteComments(comment_sequence_id);
	}
	
}
