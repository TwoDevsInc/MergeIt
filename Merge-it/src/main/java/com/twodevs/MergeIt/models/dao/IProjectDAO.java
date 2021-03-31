package com.twodevs.MergeIt.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twodevs.MergeIt.models.entities.Project;
import com.twodevs.MergeIt.models.entities.Team;

@Repository
public interface IProjectDAO extends JpaRepository<Project,Integer>{
	List<Project> findByTeamId(Integer id_team);
}
