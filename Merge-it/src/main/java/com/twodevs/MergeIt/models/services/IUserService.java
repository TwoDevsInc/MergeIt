package com.twodevs.MergeIt.models.services;

import java.util.List;

import com.twodevs.MergeIt.models.entities.User;

public interface IUserService {

	public List<User> findAll();

    public User save(User user);

    public User findById(Integer id);

    public void delete(User user);

    public void deleteById(Integer id);
}
