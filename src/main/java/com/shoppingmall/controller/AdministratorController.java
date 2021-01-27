package com.shoppingmall.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingmall.mapper.AdministratorMapper;
import com.shoppingmall.model.Administrator;


@RestController
@RequestMapping("/administrator")
@CrossOrigin(origins="http://localhost:5000")
public class AdministratorController {

	@Autowired
	private AdministratorMapper administratorMapper;
	
	@PostMapping("")
	public Administrator insert(@RequestBody Administrator administrator) {
		administratorMapper.insertAdministrator(administrator);
		return administrator;
	}

	@GetMapping("/all")
	public List<Administrator> getAll(){
		return administratorMapper.getAll();
	}
	
	@PutMapping("/{administrator_id}")
	public void update(@PathVariable("administrator_id")String administrator_id, 
			@Param("administrator_pwd") String administrator_pwd,@Param("administrator_name") String administrator_name) {
		administratorMapper.updateAdministrator(administrator_id, administrator_pwd, administrator_name);
		}
	
	@DeleteMapping("/{administrator_id}")
	public void delete(@PathVariable("administrator_id")String administrator_id){
		administratorMapper.deleteAdministrator(administrator_id);
	}
		
}
