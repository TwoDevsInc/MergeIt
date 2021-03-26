package com.twodevs.MergeIt.models.services;

import java.util.List;

import com.twodevs.MergeIt.models.entities.Task;

public interface ITaskService {
	
	public List<Task> findAll();

	public Task save(Task task);

	public Task findById(Integer id);

	public void delete(Task task);

	public void deleteById(Integer id);
}
