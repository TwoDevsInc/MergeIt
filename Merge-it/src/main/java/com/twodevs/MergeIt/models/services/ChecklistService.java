package com.twodevs.MergeIt.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twodevs.MergeIt.models.dao.IChecklistDAO;
import com.twodevs.MergeIt.models.entities.Checklist;

@Service
public class ChecklistService implements IChecklistService {

	@Autowired
	IChecklistDAO checklistDAO;
	
	@Override
	public List<Checklist> findAll() {
		return checklistDAO.findAll();
	}

	@Override
	public Checklist save(Checklist checklist) {
		return checklistDAO.save(checklist);
	}

	@Override
	public Checklist findById(Integer id) {
		return checklistDAO.findById(id).orElse(null);
	}

	@Override
	public void delete(Checklist checklist) {
		checklistDAO.delete(checklist);
	}

	@Override
	public void deleteById(Integer id) {
		checklistDAO.deleteById(id);
	}

}
