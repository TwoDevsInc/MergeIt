package com.twodevs.MergeIt.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.twodevs.MergeIt.models.dao.IUserDAO;
import com.twodevs.MergeIt.models.entities.User;

@Service
public class UserService implements IUserService{

	@Autowired
	IUserDAO userDAO;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public List<User> findAll() {		
		return userDAO.findAll();
	}

	@Override
	public User save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userDAO.save(user);
	}

	@Override
	public User findById(Integer id) {
		return userDAO.findById(id).orElse(null);
	}
	
	@Override
	public User findByUsername(String username) {
		return userDAO.findByUsername(username).orElse(null);
	}

	@Override
	public void delete(User user) {
		userDAO.delete(user);
	}

	@Override
	public void deleteById(Integer id) {
		userDAO.deleteById(id);
	}

	
	
	
	
}
