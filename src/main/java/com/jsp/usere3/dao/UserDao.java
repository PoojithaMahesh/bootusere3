package com.jsp.usere3.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.usere3.dto.User;
import com.jsp.usere3.repo.UserRepo;

@Repository
public class UserDao {
	@Autowired
	private UserRepo repo;

	public User saveUser(User user) {
         return repo.save(user);
	}

	public User findUserById(int id) {
		Optional<User> optional=repo.findById(id);
		if(optional.isPresent()) {
			User user=optional.get();
			return user;
		}
		return null;
	}

	public User deleteUserById(int id) {
		Optional<User> optional=repo.findById(id);
		if(optional.isPresent()) {
//			User is present then i can delete the data
			User user=optional.get();
			repo.delete(user);
			return user;
		}
		return null;
	}

	public User updateUser(int id, User user) {
		Optional<User> optional=repo.findById(id);
		if(optional.isPresent()) {
//			User is present
			user.setId(id);
			return repo.save(user);
		}
		return null;
	}

	public List<User> findAllStudents() {
		
		return repo.findAll();
	}

}
