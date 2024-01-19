package com.jsp.usere3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.usere3.dao.UserDao;
import com.jsp.usere3.dto.User;
import com.jsp.usere3.service.UserService;
import com.jsp.usere3.util.ResponseStructure;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<User> > saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}	
	@GetMapping("/find")
	public ResponseEntity<ResponseStructure<User>> findUserById(@RequestParam int id) {
		return service.findUserById(id);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@RequestParam int id) {
		return service.deleteUserById(id);
	}
	
	@PutMapping("/update")
     public ResponseEntity<ResponseStructure<User>> updateUser(@RequestParam int id,@RequestBody User user) {
		return service.updateUser(id,user);
	}
	
	
	@GetMapping("/findall")
	public ResponseEntity<ResponseStructure<List<User>>> findAllSTudents(){
		return service.findAllStudents();
	}
	
}
