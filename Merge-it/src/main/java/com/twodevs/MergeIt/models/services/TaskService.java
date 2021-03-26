package com.twodevs.MergeIt.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twodevs.MergeIt.models.dao.ITaskDAO;
import com.twodevs.MergeIt.models.entities.Task;


@Service
public class TaskService implements ITaskService{
	
	@Autowired
	ITaskDAO taskDAO;

	@Override
	public List<Task> findAll() {
		return taskDAO.findAll();
	}

	@Override
	public Task save(Task task) {
		return taskDAO.save(task);
	}

	@Override
	public Task findById(Integer id) {
		return taskDAO.findById(id).orElse(null);
	}

	@Override
	public void delete(Task task) {
		taskDAO.delete(task);
	}

	@Override
	public void deleteById(Integer id) {
		taskDAO.deleteById(id);
	}

}
