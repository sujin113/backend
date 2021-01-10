package com.codelifee.exercisecoach.exercisecoach.resource;

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

import com.codelifee.exercisecoach.exercisecoach.mapper.AdministratorMapper;
import com.codelifee.exercisecoach.exercisecoach.model.Administrator;

@RestController
@RequestMapping("/rest/administrator")
@CrossOrigin(origins="http://localhost:5000")
public class AdministratorResource {

	private AdministratorMapper administratorMapper;

	@Autowired
	public AdministratorResource(AdministratorMapper administratorMapper) {
		this.administratorMapper = administratorMapper;
	}
	
	@GetMapping("/all")
	public Administrator getAdministrator() {
		return administratorMapper.getAdministrator();
	}
	
	@PutMapping("/create_administrator")
	public void createAdministrator(@RequestParam("admin_id")String admin_id,@RequestParam("admin_pwd")String admin_pwd,
			@RequestParam("admin_name")String admin_name) {
		administratorMapper.insertAdministrator(admin_id, admin_pwd, admin_name);
	}
	
	@PostMapping("/{admin_id}")
	public void updateAdministrator(@PathVariable("admin_id")String admin_id, @RequestParam("admin_pwd")String admin_pwd,
			@RequestParam("admin_name")String admin_name) {
		administratorMapper.updateAdministrator(admin_id, admin_pwd, admin_name);
	}
	
	@DeleteMapping("{admin_id}")
	public void deleteAdministrator(@PathVariable("admin_id")String admin_id){
		administratorMapper.deleteAdministrator(admin_id);
	}
		
}
