package com.twodevs.MergeIt.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twodevs.MergeIt.models.dao.IProjectDAO;
import com.twodevs.MergeIt.models.entities.Project;

@Service
public class ProjectService implements IProjectService{
	
	@Autowired
	IProjectDAO projectDAO;

	@Override
	public List<Project> findAll() {
		return projectDAO.findAll();
	}
	
	@Override
	public List<Project> findByTeamId(Integer id_team) {
		return projectDAO.findByTeamId(id_team);
	}

	@Override
	public Project save(Project project) {
		return projectDAO.save(project);
	}

	@Override
	public Project findById(Integer id) {
		return projectDAO.findById(id).orElse(null);
	}

	@Override
	public void delete(Project project) {
		projectDAO.delete(project);
	}

	@Override
	public void deleteById(Integer id) {
		projectDAO.deleteById(id);
	}

	

}
