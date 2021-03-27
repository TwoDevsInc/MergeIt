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

import com.twodevs.MergeIt.models.entities.Project;
import com.twodevs.MergeIt.models.services.ProjectService;


@RestController
@RequestMapping("project")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Project>> getProjects(){
		List<Project> projects = projectService.findAll();
		return new ResponseEntity<>(projects,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Project> getProjectById(@PathVariable Integer id){
		Project project = projectService.findById(id);
		return new ResponseEntity<>(project,HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Project> addProject(@RequestBody Project project){
		Project newProject = projectService.save(project);
		return new ResponseEntity<>(newProject,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Project> updateProject(@RequestBody Project project){
		Project projectUpdated = projectService.save(project);
		return new ResponseEntity<>(projectUpdated,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProject(@PathVariable("id") Integer id){
		projectService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
