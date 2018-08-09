package com.stackroute.userapp.services;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public String getAllUsers() {

		String str = "Hello user";
		return str;

	}

}
