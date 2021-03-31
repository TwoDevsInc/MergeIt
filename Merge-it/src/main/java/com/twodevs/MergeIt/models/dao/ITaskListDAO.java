package com.twodevs.MergeIt.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.twodevs.MergeIt.models.entities.TaskList;

@Repository
public interface ITaskListDAO extends JpaRepository<TaskList,Integer>{
	List<TaskList> findByProjectId(Integer id_project);
}
