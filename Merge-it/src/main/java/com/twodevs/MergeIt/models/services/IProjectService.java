package com.twodevs.MergeIt.models.services;

import java.util.List;

import com.twodevs.MergeIt.models.entities.Project;

public interface IProjectService {
	
	public List<Project> findAll();
	
	public List<Project> findByTeamId(Integer id_team);

	public Project save(Project project);

	public Project findById(Integer id);

	public void delete(Project project);

	public void deleteById(Integer id);
}
