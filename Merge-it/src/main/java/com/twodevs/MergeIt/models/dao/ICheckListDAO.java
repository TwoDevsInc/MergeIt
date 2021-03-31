package com.twodevs.MergeIt.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twodevs.MergeIt.models.entities.CheckList;
import com.twodevs.MergeIt.models.entities.Project;

@Repository
public interface ICheckListDAO extends JpaRepository<CheckList, Integer>{

	List<CheckList> findByTaskId(Integer id_task);
}
