package com.twodevs.MergeIt.models.services;

import java.util.List;

import com.twodevs.MergeIt.models.entities.CheckListItem;

public interface ICheckListItemService {
	public List<CheckListItem> findAll();

    public CheckListItem save(CheckListItem checkListItem);

    public CheckListItem findById(Integer id);

    public void delete(CheckListItem checkListItem);

    public void deleteById(Integer id);
}
