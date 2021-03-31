package com.twodevs.MergeIt.models.services;

import java.util.List;

import com.twodevs.MergeIt.models.entities.File;



public interface IFileService {
	
	public List<File> findAll();
	
	public List<File> findByTaskId(Integer id_task);

    public File save(File file);

    public File findById(Integer id);

    public void delete(File file);

    public void deleteById(Integer id);
}
