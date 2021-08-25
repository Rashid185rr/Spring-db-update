package com.test.daoImpl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entities.User;
import com.test.repository.UserRepository;

@Service
public class UserService  {

	@Autowired
	UserRepository repository;
	 
	
	public void saveOrUpdate(User user) {
		repository.save(user);
	}
	



}
