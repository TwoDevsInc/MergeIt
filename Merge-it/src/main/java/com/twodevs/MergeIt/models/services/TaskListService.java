package com.twodevs.MergeIt.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twodevs.MergeIt.models.dao.ITaskListDAO;
import com.twodevs.MergeIt.models.entities.TaskList;


@Service
public class TaskListService implements ITaskListService{
	
	@Autowired
	ITaskListDAO taskListDAO;

	@Override
	public List<TaskList> findAll() {
		return taskListDAO.findAll();
	}

	@Override
	public TaskList save(TaskList list) {
		return taskListDAO.save(list);
	}

	@Override
	public TaskList findById(Integer id) {
		return taskListDAO.findById(id).orElse(null);
	}

	@Override
	public void delete(TaskList list) {
		taskListDAO.delete(list);
	}

	@Override
	public void deleteById(Integer id) {
		taskListDAO.deleteById(id);
	}

}
