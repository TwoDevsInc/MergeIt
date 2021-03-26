package com.twodevs.MergeIt.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twodevs.MergeIt.models.dao.IListsDAO;
import com.twodevs.MergeIt.models.entities.Lists;


@Service
public class ListsService implements IListsService{
	
	@Autowired
	IListsDAO listsDAO;

	@Override
	public List<Lists> findAll() {
		return listsDAO.findAll();
	}

	@Override
	public Lists save(Lists list) {
		return listsDAO.save(list);
	}

	@Override
	public Lists findById(Integer id) {
		return listsDAO.findById(id).orElse(null);
	}

	@Override
	public void delete(Lists list) {
		listsDAO.delete(list);
	}

	@Override
	public void deleteById(Integer id) {
		listsDAO.deleteById(id);
	}

}
