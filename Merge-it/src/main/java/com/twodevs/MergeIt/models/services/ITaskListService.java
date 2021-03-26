package com.twodevs.MergeIt.models.services;

import java.util.List;

import com.twodevs.MergeIt.models.entities.TaskList;

public interface ITaskListService {
	
	public List<TaskList> findAll();

	public TaskList save(TaskList list);

	public TaskList findById(Integer id);

	public void delete(TaskList list);

	public void deleteById(Integer id);
}
