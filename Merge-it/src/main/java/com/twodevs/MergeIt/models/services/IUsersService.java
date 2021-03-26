package com.twodevs.MergeIt.models.services;

import java.util.List;

import com.twodevs.MergeIt.models.entities.Users;

public interface IUsersService {

	public List<Users> findAll();

    public Users save(Users user);

    public Users findById(Integer id);

    public void delete(Users user);

    public void deleteById(Integer id);
}
