package com.training.bms.model;

import java.io.IOException;
import java.util.List;

import com.training.bms.model.User;

public interface UserDao {	
		public List<User> getUsers();
		public int getUserById(int id);
		public String createUser(User user );
		public String updateUser(User user );
		public int deleteUserById(int id) throws IOException;
	}

