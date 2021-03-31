package com.twodevs.MergeIt.models.services;

import java.util.List;

import com.twodevs.MergeIt.models.entities.Project;
import com.twodevs.MergeIt.models.entities.Task;

public interface ITaskService {
	
	public List<Task> findAll();
	
	public List<Task> findByTaskListId(Integer id_task_list);

	public Task save(Task task);

	public Task findById(Integer id);

	public void delete(Task task);

	public void deleteById(Integer id);
}
