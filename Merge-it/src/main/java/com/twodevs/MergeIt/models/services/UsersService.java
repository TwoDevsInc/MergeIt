package com.twodevs.MergeIt.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twodevs.MergeIt.models.dao.IUsersDAO;
import com.twodevs.MergeIt.models.entities.Users;

@Service
public class UsersService implements IUsersService{

	@Autowired
	IUsersDAO userDao;

	@Override
	public List<Users> findAll() {		
		return userDao.findAll();
	}

	@Override
	public Users save(Users user) {
		return userDao.save(user);
	}

	@Override
	public Users findById(Integer id) {
		return userDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Users user) {
		userDao.delete(user);
	}

	@Override
	public void deleteById(Integer id) {
		userDao.deleteById(id);
	}
	
	
	
}
