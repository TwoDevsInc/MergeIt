package com.twodevs.MergeIt.models.services;

import java.util.List;

import com.twodevs.MergeIt.models.entities.CheckList;



public interface ICheckListService {
	public List<CheckList> findAll();

    public CheckList save(CheckList checkList);

    public CheckList findById(Integer id);

    public void delete(CheckList checkList);

    public void deleteById(Integer id);
}
