package com.twodevs.MergeIt.models.services;

import java.util.List;

import com.twodevs.MergeIt.models.entities.Teams;


public interface ITeamsService {
	
	public List<Teams> findAll();
	
	public Teams save(Teams team);
	
	public Teams findById(Integer id);
	
	public void delete(Teams cliente);
	
	public void deleteById(Integer id);

}
