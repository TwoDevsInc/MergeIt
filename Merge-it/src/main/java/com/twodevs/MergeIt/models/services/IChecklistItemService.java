package com.twodevs.MergeIt.models.services;

import java.util.List;

import com.twodevs.MergeIt.models.entities.ChecklistItem;

public interface IChecklistItemService {
	public List<ChecklistItem> findAll();

    public ChecklistItem save(ChecklistItem checklistItem);

    public ChecklistItem findById(Integer id);

    public void delete(ChecklistItem checklistItem);

    public void deleteById(Integer id);
}
