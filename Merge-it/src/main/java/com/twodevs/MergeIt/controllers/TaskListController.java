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

import com.twodevs.MergeIt.models.entities.TaskList;
import com.twodevs.MergeIt.models.entities.dto.TaskListDTO;
import com.twodevs.MergeIt.models.services.TaskListService;


@RestController
@RequestMapping("/taskList")
public class TaskListController {
	
	@Autowired
	TaskListService taskListService;
	
	@GetMapping("/all")
	public ResponseEntity<List<TaskListDTO>> getTaskLists(){
		List<TaskListDTO> taskList = taskListService.findAll().stream().map(t -> new TaskListDTO(t)).collect(Collectors.toList());
		return new ResponseEntity<>(taskList,HttpStatus.OK);
	}
	
	@GetMapping("/taskListsByProject/{id_project}")
	public ResponseEntity<List<TaskListDTO>> getTaskListsByProjectId(@PathVariable Integer id_project){
		List<TaskListDTO> taskLists = taskListService.findByProjectId(id_project).stream().map(t -> new TaskListDTO(t)).collect(Collectors.toList());
		return new ResponseEntity<>(taskLists,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TaskListDTO> getTaskListById(@PathVariable Integer id){
		TaskListDTO taskList = new TaskListDTO(taskListService.findById(id));
		return new ResponseEntity<>(taskList,HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<TaskListDTO> addTaskList(@RequestBody TaskList taskList){
		TaskListDTO newTaskList = new TaskListDTO(taskListService.save(taskList));
		return new ResponseEntity<>(newTaskList,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<TaskListDTO> updateTaskList(@RequestBody TaskList taskList){
		TaskListDTO taskListUpdated = new TaskListDTO(taskListService.save(taskList));
		return new ResponseEntity<>(taskListUpdated,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> updateTaskList(@PathVariable("id") Integer id){
		taskListService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
