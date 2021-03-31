package com.twodevs.MergeIt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twodevs.MergeIt.models.entities.File;
import com.twodevs.MergeIt.models.services.FileService;

@RestController
@RequestMapping("/file")
public class FilesController {

	@Autowired
	FileService fileService;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<File>> getFiles(){
		List<File> file = fileService.findAll();
		return new ResponseEntity<>(file, HttpStatus.OK); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<File> getFileById(@PathVariable Integer id){
		File file = fileService.findById(id);
		return new ResponseEntity<>(file, HttpStatus.OK);
	}
	
	@GetMapping("/filesByTask/{id_task}")
	public ResponseEntity<List<File>> getFilesByTaskId(@PathVariable Integer id_task){
		List<File> files = fileService.findByTaskId(id_task);
		return new ResponseEntity<>(files, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<File> addFile(@RequestBody File file){
		File newFile = fileService.save(file);
		return new ResponseEntity<>(newFile, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<File> updateFile(@RequestBody File file){
		File updatedFile = fileService.save(file);
		return new ResponseEntity<>(updatedFile, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteFile(@PathVariable("id") Integer id){
		fileService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
