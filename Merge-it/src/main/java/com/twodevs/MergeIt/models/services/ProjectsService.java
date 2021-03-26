package com.twodevs.MergeIt.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twodevs.MergeIt.models.dao.IProjectsDAO;
import com.twodevs.MergeIt.models.entities.Projects;

@Service
public class ProjectsService implements IProjectsService{
	
	@Autowired
	IProjectsDAO projectsDAO;

	@Override
	public List<Projects> findAll() {
		return projectsDAO.findAll();
	}

	@Override
	public Projects save(Projects project) {
		return projectsDAO.save(project);
	}

	@Override
	public Projects findById(Integer id) {
		return projectsDAO.findById(id).orElse(null);
	}

	@Override
	public void delete(Projects project) {
		projectsDAO.delete(project);
	}

	@Override
	public void deleteById(Integer id) {
		projectsDAO.deleteById(id);
	}

}
