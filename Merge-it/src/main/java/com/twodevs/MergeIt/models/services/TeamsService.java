package com.twodevs.MergeIt.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twodevs.MergeIt.models.dao.ITeamsDAO;
import com.twodevs.MergeIt.models.entities.Teams;

@Service
public class TeamsService implements ITeamsService{
	
	@Autowired
	ITeamsDAO teamsDAO;

	@Override
	public List<Teams> findAll() {		
		return teamsDAO.findAll();
	}

	@Override
	public Teams save(Teams team) {
		return teamsDAO.save(team);
	}

	@Override
	public Teams findById(Integer id) {
		return teamsDAO.findById(id).orElse(null);
	}

	@Override
	public void delete(Teams team) {		
		teamsDAO.delete(team);
	}

	@Override
	public void deleteById(Integer id) {
		teamsDAO.deleteById(id);		
	}
	
	

}
