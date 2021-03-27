package com.twodevs.MergeIt.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twodevs.MergeIt.models.dao.IFileDAO;
import com.twodevs.MergeIt.models.entities.File;

@Service
public class FileService implements IFileService {

	@Autowired
	IFileDAO fileDAO;
	
	@Override
	public List<File> findAll() {
		return fileDAO.findAll();
	}

	@Override
	public File save(File file) {
		return fileDAO.save(file);
	}

	@Override
	public File findById(Integer id) {
		return fileDAO.findById(id).orElse(null);
	}

	@Override
	public void delete(File file) {
		fileDAO.delete(file);
	}

	@Override
	public void deleteById(Integer id) {
		fileDAO.deleteById(id);
	}

	
}
