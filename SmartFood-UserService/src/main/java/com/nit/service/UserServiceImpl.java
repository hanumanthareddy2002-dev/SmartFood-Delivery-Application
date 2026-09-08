package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nit.dto.RegisterRequest;
import com.nit.dto.UserResponse;
import com.nit.entity.User;
import com.nit.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userrepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User createUser(User user) {
		if(userrepository.existsByEmail(user.getEmail())){
			throw new RuntimeException("Email already exits");
		}
		//user.setActive(true);
		return userrepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		
		return userrepository.findAll();
	}

	@Override
	public User getUsersById(Long id) {
		
		return userrepository.findById(id)
				.orElseThrow(()->
				new RuntimeException("User not found with id: "+id));
	}

	@Override
	public User updateUser(Long id, User user) {
		User exist=getUsersById(id);
		exist.setName(user.getName());
		exist.setPhone(user.getPhone());
		
		/*if(user.getActive()!=null) {
			exist.setActive(user.getActive());
		}*/
		if(user.getPassword()!=null&&!user.getPassword().isBlank()) {
			exist.setPassword(passwordEncoder.encode(user.getPassword()));
		}
		return userrepository.save(exist);
	}

	@Override
	public void deleteUser(Long id) {
		/*User existdelete=getUsersById(id);
		existdelete.setActive(false);*/
		if(!userrepository.existsById(id)) {
			throw new RuntimeException("User not found");
		}
		userrepository.deleteById(id);
		
	}

	@Override
	public User getUserByEmail(String email) {
		
		return userrepository.findByEmail(email).orElseThrow(()-> new RuntimeException("User not found with email: "+email));
	}

	/*@Override
	public UserResponse register(RegisterRequest request) {
		if(userrepository.existsByEmail(request.getEmail())) {
			throw new EmailAlreadyExistsException("Email already registerd");
		}
		User user=new User();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setPhone(request.getPhone());
		user.setRole(request.getRole());
		User savedUser=userrepository.save(user);
		return convertToResponse(savedUser);
	}*/

	

}
