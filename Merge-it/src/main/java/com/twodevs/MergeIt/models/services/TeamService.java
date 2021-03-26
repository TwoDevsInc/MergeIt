package com.twodevs.MergeIt.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twodevs.MergeIt.models.dao.ITeamDAO;
import com.twodevs.MergeIt.models.entities.Team;

@Service
public class TeamService implements ITeamService{
	
	@Autowired
	ITeamDAO teamDAO;

	@Override
	public List<Team> findAll() {		
		return teamDAO.findAll();
	}

	@Override
	public Team save(Team team) {
		return teamDAO.save(team);
	}

	@Override
	public Team findById(Integer id) {
		return teamDAO.findById(id).orElse(null);
	}

	@Override
	public void delete(Team team) {		
		teamDAO.delete(team);
	}

	@Override
	public void deleteById(Integer id) {
		teamDAO.deleteById(id);		
	}
	
	

}
