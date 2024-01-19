package com.jsp.usere3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.usere3.dao.UserDao;
import com.jsp.usere3.dto.User;
import com.jsp.usere3.util.ResponseStructure;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		User dbUser = dao.saveUser(user);
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setMessage("Data saved successfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(dbUser);
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> findUserById(int id) {
		User dbUser = dao.findUserById(id);
		if (dbUser != null) {
//			id is present
			ResponseStructure<User> structure = new ResponseStructure<User>();
			structure.setMessage("Data fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND);
		} else {
//			id is not present
			ResponseStructure<User> structure = new ResponseStructure<User>();
			structure.setMessage("Data NOT Found");
			structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<User>> deleteUserById(int id) {
		User dbUser = dao.deleteUserById(id);
		if (dbUser != null) {
//			id is present
			ResponseStructure<User> structure = new ResponseStructure<User>();
			structure.setMessage("Data Deleted successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND);
		} else {
//			id is not present
			ResponseStructure<User> structure = new ResponseStructure<User>();
			structure.setMessage("Data NOT Found");
			structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(int id, User user) {
		User dbUser = dao.updateUser(id, user);
		if (dbUser != null) {
//			id is present and it is updated
			ResponseStructure<User> structure = new ResponseStructure<User>();
			structure.setMessage("Data Updated successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		} else {
//			id is not present
			ResponseStructure<User> structure = new ResponseStructure<User>();
			structure.setMessage("Data NOT Found");
			structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<List<User>>> findAllStudents() {
		List<User> list = dao.findAllStudents();
		ResponseStructure<List<User>> structure=new ResponseStructure<>();
		structure.setMessage("Data fetched successfully");
		structure.setHttpStatus(HttpStatus.FOUND.value());
		structure.setData(list);
		return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.FOUND);
	}

}
