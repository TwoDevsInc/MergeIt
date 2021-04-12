package com.twodevs.MergeIt.controllers;

import java.util.List;
import java.util.stream.Collectors;

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
import com.twodevs.MergeIt.models.entities.dto.FileDTO;
import com.twodevs.MergeIt.models.services.FileService;

@RestController
@RequestMapping("/file")
public class FilesController {

	@Autowired
	FileService fileService;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<FileDTO>> getFiles(){
		List<FileDTO> file = fileService.findAll().stream().map(f -> new FileDTO(f)).collect(Collectors.toList());
		return new ResponseEntity<>(file, HttpStatus.OK); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FileDTO> getFileById(@PathVariable Integer id){
		FileDTO file = new FileDTO(fileService.findById(id));
		return new ResponseEntity<>(file, HttpStatus.OK);
	}
	
	@GetMapping("/filesByTask/{id_task}")
	public ResponseEntity<List<FileDTO>> getFilesByTaskId(@PathVariable Integer id_task){
		List<FileDTO> files = fileService.findByTaskId(id_task).stream().map(f -> new FileDTO(f)).collect(Collectors.toList());
		return new ResponseEntity<>(files, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<FileDTO> addFile(@RequestBody File file){
		FileDTO newFile = new FileDTO(fileService.save(file));
		return new ResponseEntity<>(newFile, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<FileDTO> updateFile(@RequestBody File file){
		FileDTO updatedFile = new FileDTO(fileService.save(file));
		return new ResponseEntity<>(updatedFile, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteFile(@PathVariable("id") Integer id){
		fileService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
