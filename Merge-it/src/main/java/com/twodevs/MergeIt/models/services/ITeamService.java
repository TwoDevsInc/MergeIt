package com.twodevs.MergeIt.models.services;

import java.util.List;

import com.twodevs.MergeIt.models.entities.Team;


public interface ITeamService {
	
	public List<Team> findAll();
	
	public Team save(Team team);
	
	public Team findById(Integer id);
	
	public void delete(Team cliente);
	
	public void deleteById(Integer id);

}
