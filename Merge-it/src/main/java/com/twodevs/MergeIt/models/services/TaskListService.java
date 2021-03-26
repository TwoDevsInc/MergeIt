package com.twodevs.MergeIt.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twodevs.MergeIt.models.dao.IListDAO;
import com.twodevs.MergeIt.models.entities.TaskList;


@Service
public class TaskListService implements ITaskListService{
	
	@Autowired
	IListDAO listDAO;

	@Override
	public List<TaskList> findAll() {
		return listDAO.findAll();
	}

	@Override
	public TaskList save(TaskList list) {
		return listDAO.save(list);
	}

	@Override
	public TaskList findById(Integer id) {
		return listDAO.findById(id).orElse(null);
	}

	@Override
	public void delete(TaskList list) {
		listDAO.delete(list);
	}

	@Override
	public void deleteById(Integer id) {
		listDAO.deleteById(id);
	}

}
