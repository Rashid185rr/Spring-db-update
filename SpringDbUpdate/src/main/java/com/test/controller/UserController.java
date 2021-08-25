package com.test.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.daoImpl.UserService;
import com.test.entities.User;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	Properties properties;
	
	@PostMapping("/user")
	public void insert() {
		
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		User user=new User();
		user.setId(Integer.parseInt(properties.getProperty("id")));
		user.setName(properties.getProperty("name"));
		user.setBatch(properties.getProperty("batch"));
		user.setDepartment(properties.getProperty("department"));
		
		userService.saveOrUpdate(user);		
		
	}
	
}
