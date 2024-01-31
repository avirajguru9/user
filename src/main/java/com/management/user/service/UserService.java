package com.management.user.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.management.user.model.User;
import com.management.user.repository.UserRepository;

@Service
public class UserService implements UserInterface {

	@Autowired
	private UserRepository userRepo;
	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User manageSubscription(Integer id, Boolean subs) {
		User user = userRepo.findById(id).orElseThrow(()->new NoSuchElementException("User not fund"));
		user.setSubscription(subs);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public Optional<User> getUserById(Integer id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id);
	}

	@Override
	public void deleteUser(User id) {
		userRepo.delete(id);
	}

}
