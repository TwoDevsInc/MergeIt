package com.twodevs.MergeIt.models.services;

import java.util.List;

import com.twodevs.MergeIt.models.entities.Projects;

public interface IProjectsService {
	
	public List<Projects> findAll();

	public Projects save(Projects project);

	public Projects findById(Integer id);

	public void delete(Projects project);

	public void deleteById(Integer id);
}
