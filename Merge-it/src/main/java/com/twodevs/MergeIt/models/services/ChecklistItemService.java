package com.twodevs.MergeIt.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twodevs.MergeIt.models.dao.IChecklistItemDAO;
import com.twodevs.MergeIt.models.entities.ChecklistItem;

@Service
public class ChecklistItemService implements IChecklistItemService {

	@Autowired
	IChecklistItemDAO checklistItemDAO;
	
	@Override
	public List<ChecklistItem> findAll() {
		return checklistItemDAO.findAll();
	}

	@Override
	public ChecklistItem save(ChecklistItem checklistItem) {
		return checklistItemDAO.save(checklistItem);
	}

	@Override
	public ChecklistItem findById(Integer id) {
		return checklistItemDAO.findById(id).orElse(null);
	}

	@Override
	public void delete(ChecklistItem checklistItem) {
		checklistItemDAO.delete(checklistItem);
	}

	@Override
	public void deleteById(Integer id) {
		checklistItemDAO.deleteById(id);
	}

}
