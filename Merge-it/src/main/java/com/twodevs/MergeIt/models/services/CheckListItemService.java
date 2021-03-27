package com.twodevs.MergeIt.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twodevs.MergeIt.models.dao.ICheckListItemDAO;
import com.twodevs.MergeIt.models.entities.CheckListItem;

@Service
public class CheckListItemService implements ICheckListItemService {

	@Autowired
	ICheckListItemDAO checkListItemDAO;
	
	@Override
	public List<CheckListItem> findAll() {
		return checkListItemDAO.findAll();
	}

	@Override
	public CheckListItem save(CheckListItem checkListItem) {
		return checkListItemDAO.save(checkListItem);
	}

	@Override
	public CheckListItem findById(Integer id) {
		return checkListItemDAO.findById(id).orElse(null);
	}

	@Override
	public void delete(CheckListItem checkListItem) {
		checkListItemDAO.delete(checkListItem);
	}

	@Override
	public void deleteById(Integer id) {
		checkListItemDAO.deleteById(id);
	}

}
