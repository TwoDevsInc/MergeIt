package com.twodevs.MergeIt.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twodevs.MergeIt.models.dao.ICheckListDAO;
import com.twodevs.MergeIt.models.entities.CheckList;

@Service
public class CheckListService implements ICheckListService {

	@Autowired
	ICheckListDAO checkListDAO;
	
	@Override
	public List<CheckList> findAll() {
		return checkListDAO.findAll();
	}
	
	@Override
	public List<CheckList> findByTaskId(Integer id_task) {
		return checkListDAO.findByTaskId(id_task);
	}

	@Override
	public CheckList save(CheckList checkList) {
		return checkListDAO.save(checkList);
	}

	@Override
	public CheckList findById(Integer id) {
		return checkListDAO.findById(id).orElse(null);
	}

	@Override
	public void delete(CheckList checkList) {
		checkListDAO.delete(checkList);
	}

	@Override
	public void deleteById(Integer id) {
		checkListDAO.deleteById(id);
	}

	

}
