package com.codelifee.exercisecoach.exercisecoach.resource;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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

import com.codelifee.exercisecoach.exercisecoach.mapper.UsersMapper;
import com.codelifee.exercisecoach.exercisecoach.model.Users;

@RestController
@RequestMapping("/rest/users")
@CrossOrigin(origins="http://localhost:5000")
public class UsersResource {

	private UsersMapper usersMapper;
			
	@Autowired
	public UsersResource(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}

	@GetMapping("/all")
	public List<Users> getAll() {
		return usersMapper.findAll();
	}
	
	@GetMapping("/{user_id}")
	public Users getUsers(@PathVariable("user_id")String user_id) {
		return usersMapper.getUsers(user_id);
	}
	
	@PutMapping("/create_user")
	public void createUsers(@RequestParam("user_id")String user_id, @RequestParam("user_pwd")String user_pwd, 
			@RequestParam("user_name")String user_name, @RequestParam("user_year")int user_year, 
			@RequestParam("user_month")int user_month, @RequestParam("user_day")int user_day, 
			@RequestParam("user_email") String user_email, @RequestParam("user_mobile") String user_mobile) {
		usersMapper.insertUsers(user_id, user_pwd, user_name, user_year, user_month, user_day, user_email, user_mobile);
	}
	
	@PostMapping("/{user_id}")
	public void updateUsers(@PathVariable("user_id")String user_id, @RequestParam("user_pwd")String user_pwd, 
			@RequestParam("user_name")String user_name, @RequestParam("user_year")int user_year, 
			@RequestParam("user_month")int user_month, @Param("user_day")int user_day, 
			@RequestParam("user_email") String user_email, @RequestParam("user_mobile") String user_mobile) {
		usersMapper.updateUsers(user_id, user_pwd, user_name, user_year, user_month, user_day, user_email, user_mobile);
	}
	
	@DeleteMapping("/{user_id}")
	public void deleteUsers(@PathVariable("user_id")String user_id) {
		usersMapper.deleteUsers(user_id);
	}
}
