package com.twodevs.MergeIt.models.services;

import java.util.List;

import com.twodevs.MergeIt.models.entities.Checklist;



public interface IChecklistService {
	public List<Checklist> findAll();

    public Checklist save(Checklist checklist);

    public Checklist findById(Integer id);

    public void delete(Checklist checklist);

    public void deleteById(Integer id);
}
