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

import com.codelifee.exercisecoach.exercisecoach.mapper.ExercisesMapper;
import com.codelifee.exercisecoach.exercisecoach.model.Exercises;

@RestController
@RequestMapping("/rest/exercises")
@CrossOrigin(origins="http://localhost:5000")
public class ExercisesResource {

	private ExercisesMapper exercisesMapper;
			
	@Autowired
	public ExercisesResource(ExercisesMapper exercisesMapper) {
		this.exercisesMapper = exercisesMapper;
	}

	@GetMapping("/all")
	public List<Exercises> getAll() {
		return exercisesMapper.findAll();
	}
	
	@GetMapping("/{exercise_sequence_id}")
	public Exercises getExercises(@PathVariable("exercise_sequence_id")int exercise_sequence_id) {
		return exercisesMapper.getExercises(exercise_sequence_id);
	}
	
	@PutMapping("/create_exercise")
	public void createExercises(@RequestParam("exercise_name")String exercise_name, 
			@RequestParam("descriptions")String descriptions) {
		exercisesMapper.insertExercises(exercise_name, descriptions);
	}
	
	@PostMapping("/{exercise_sequence_id}")
	public void updateExercises(@PathVariable("exercise_sequence_id")int exercise_sequence_id, 
			@RequestParam("exercise_name")String exercise_name, @RequestParam("descriptions")String descriptions) {
		exercisesMapper.updateExercises(exercise_sequence_id, exercise_name, descriptions);
	}
	
	@DeleteMapping("/{exercise_sequence_id}")
	public void deleteExercises(@PathVariable("exercise_sequence_id")int exercise_sequence_id) {
		exercisesMapper.deleteExercises(exercise_sequence_id);
	}
}
