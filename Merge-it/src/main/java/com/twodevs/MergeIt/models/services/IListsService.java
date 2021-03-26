package com.twodevs.MergeIt.models.services;

import java.util.List;

import com.twodevs.MergeIt.models.entities.Lists;

public interface IListsService {
	
	public List<Lists> findAll();

	public Lists save(Lists list);

	public Lists findById(Integer id);

	public void delete(Lists list);

	public void deleteById(Integer id);
}
