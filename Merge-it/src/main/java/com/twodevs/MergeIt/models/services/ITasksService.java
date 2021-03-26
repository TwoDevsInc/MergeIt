package com.twodevs.MergeIt.models.services;

import java.util.List;

import com.twodevs.MergeIt.models.entities.Tasks;

public interface ITasksService {
	
	public List<Tasks> findAll();

	public Tasks save(Tasks task);

	public Tasks findById(Integer id);

	public void delete(Tasks task);

	public void deleteById(Integer id);
}
