package com.twodevs.MergeIt.models.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twodevs.MergeIt.models.entities.User;

@Repository
public interface IUserDAO extends JpaRepository<User, Integer>{
	Optional<User> findByUsername(String username);
}
