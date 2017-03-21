package com.kaikeba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaikeba.dao.UserDao;
import com.kaikeba.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public void addUser(User user){
		userDao.addUser(user);
	}
}
