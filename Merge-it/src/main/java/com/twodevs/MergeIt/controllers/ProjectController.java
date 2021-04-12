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

import com.twodevs.MergeIt.models.entities.Project;
import com.twodevs.MergeIt.models.entities.dto.ProjectDTO;
import com.twodevs.MergeIt.models.services.ProjectService;


@RestController
@RequestMapping("project")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@GetMapping("/all")
	public ResponseEntity<List<ProjectDTO>> getProjects(){
		List<ProjectDTO> projects = projectService.findAll().stream().map(p -> new ProjectDTO(p)).collect(Collectors.toList());
		return new ResponseEntity<>(projects,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Integer id){
		ProjectDTO project = new ProjectDTO(projectService.findById(id));
		return new ResponseEntity<>(project,HttpStatus.OK);
	}
	
	@GetMapping("/projectsByTeam/{id_team}")
	public ResponseEntity<List<ProjectDTO>> getProjectsByTeamId(@PathVariable Integer id_team){
		List<ProjectDTO> projects = projectService.findByTeamId(id_team).stream().map(p -> new ProjectDTO(p)).collect(Collectors.toList());
		return new ResponseEntity<>(projects,HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<ProjectDTO> addProject(@RequestBody Project project){
		ProjectDTO newProject = new ProjectDTO(projectService.save(project));
		return new ResponseEntity<>(newProject,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ProjectDTO> updateProject(@RequestBody Project project){
		ProjectDTO projectUpdated = new ProjectDTO(projectService.save(project));
		return new ResponseEntity<>(projectUpdated,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProject(@PathVariable("id") Integer id){
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
