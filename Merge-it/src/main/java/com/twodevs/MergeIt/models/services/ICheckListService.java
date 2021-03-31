package com.twodevs.MergeIt.models.services;

import java.util.List;

import com.twodevs.MergeIt.models.entities.CheckList;
import com.twodevs.MergeIt.models.entities.Project;



public interface ICheckListService {
	public List<CheckList> findAll();
	
	public List<CheckList> findByTaskId(Integer id_task);

    public CheckList save(CheckList checkList);

    public CheckList findById(Integer id);

    public void delete(CheckList checkList);

    public void deleteById(Integer id);
}
