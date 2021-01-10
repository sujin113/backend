package com.codelifee.exercisecoach.exercisecoach.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codelifee.exercisecoach.exercisecoach.mapper.User_ExerciseMapper;
import com.codelifee.exercisecoach.exercisecoach.model.User_Exercise;

@RestController
@RequestMapping("/rest/user_exercise")
@CrossOrigin(origins="http://localhost:5000")
public class UserExerciseResource {

	private User_ExerciseMapper user_exerciseMapper;
			
	@Autowired
	public UserExerciseResource(User_ExerciseMapper user_exerciseMapper) {
		this.user_exerciseMapper = user_exerciseMapper;
	}

	@GetMapping("/all")
	public List<User_Exercise> getAll() {
		return user_exerciseMapper.findAll();
	}
	
	@GetMapping("/{user_sequence_id}")
	public User_Exercise getExercises(@PathVariable("user_sequence_id")int user_sequence_id) {
		return user_exerciseMapper.getUsers(user_sequence_id);
	}
}
