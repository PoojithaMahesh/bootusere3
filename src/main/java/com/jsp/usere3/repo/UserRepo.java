package com.jsp.usere3.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.usere3.dto.User;

public interface UserRepo extends JpaRepository<User,Integer>{
    @Query("Select u from User u where u.name=?1")
	public Optional<List<User>> findByName(String name);

}
