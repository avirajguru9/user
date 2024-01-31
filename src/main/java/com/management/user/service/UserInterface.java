package com.management.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.management.user.model.User;

public interface UserInterface {
	
	public User saveUser(User user);
	public User updateUser(User user);
	public User manageSubscription(Integer id, Boolean subs);
	public List<User> getAllUser();
	public Optional<User> getUserById(Integer id);
	public void deleteUser(User id);
}
