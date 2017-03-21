package com.kaikeba.dao;

import org.springframework.stereotype.Repository;

import com.kaikeba.entity.User;
@Repository
public class UserDao {

	public void addUser(User user){
		System.out.println("添加用户:"+user.getName());
	}
}
