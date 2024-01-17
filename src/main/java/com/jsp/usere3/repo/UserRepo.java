package com.jsp.usere3.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.usere3.dto.User;

public interface UserRepo extends JpaRepository<User,Integer>{

}
