package com.nit.service;

import java.util.List;

//import com.nit.dto.RegisterRequest;
//import com.nit.dto.UserResponse;
import com.nit.entity.User;

public interface UserService {

	//UserResponse register(RegisterRequest request);
	User createUser(User user);
	List<User> getAllUsers();
	User getUsersById(Long id);
	User updateUser(Long id,User user);
	 void deleteUser(Long id);
	User getUserByEmail(String email);
}
