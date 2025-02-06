package com.dao.interfaces;

import java.util.ArrayList;

import com.dao.model.User;

public interface UserDAO {
	int insert(User u);
	ArrayList<User> fetchAll();
	User fetchOne(String email);
	int update(int id,String username);
	int delete(int id);
}
