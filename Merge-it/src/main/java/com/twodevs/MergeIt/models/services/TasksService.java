package com.twodevs.MergeIt.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twodevs.MergeIt.models.dao.ITasksDAO;
import com.twodevs.MergeIt.models.entities.Tasks;


@Service
public class TasksService implements ITasksService{
	
	@Autowired
	ITasksDAO tasksDAO;

	@Override
	public List<Tasks> findAll() {
		return tasksDAO.findAll();
	}

	@Override
	public Tasks save(Tasks task) {
		return tasksDAO.save(task);
	}

	@Override
	public Tasks findById(Integer id) {
		return tasksDAO.findById(id).orElse(null);
	}

	@Override
	public void delete(Tasks task) {
		tasksDAO.delete(task);
	}

	@Override
	public void deleteById(Integer id) {
		tasksDAO.deleteById(id);
	}

}
