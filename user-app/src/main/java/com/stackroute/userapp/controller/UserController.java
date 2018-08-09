package com.stackroute.userapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.userapp.services.UserService;

@RestController
@RequestMapping(value = "/api/v1/")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {

		this.userService = userService;

	}

	@RequestMapping("/")
	public String display() {

		return "Hello";

	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUsers() {

		String result = userService.getAllUsers();
		return new ResponseEntity<String>(result, HttpStatus.OK);

	}

}
