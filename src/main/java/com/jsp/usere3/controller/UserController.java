package com.jsp.usere3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.usere3.dao.UserDao;
import com.jsp.usere3.dto.User;

@RestController
public class UserController {

	@Autowired
	private UserDao dao;
	
	@RequestMapping("/saveuser")
	public void saveUser(@RequestBody User user) {
		dao.saveUser(user);
	}
}
