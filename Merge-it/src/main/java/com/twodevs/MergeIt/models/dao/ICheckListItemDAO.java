package com.twodevs.MergeIt.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twodevs.MergeIt.models.entities.CheckListItem;

@Repository
public interface ICheckListItemDAO extends JpaRepository<CheckListItem, Integer>{
	List<CheckListItem> findByCheckListId(Integer id_checklist);
}
