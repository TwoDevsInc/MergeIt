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

import com.twodevs.MergeIt.models.entities.TaskList;
import com.twodevs.MergeIt.models.services.TaskListService;


@RestController
@RequestMapping("/taskList")
public class TaskListController {
	
	@Autowired
	TaskListService taskListService;
	
	@GetMapping("/all")
	public ResponseEntity<List<TaskList>> getTaskLists(){
		List<TaskList> taskList = taskListService.findAll();
		return new ResponseEntity<>(taskList,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TaskList> getTaskListById(@PathVariable Integer id){
		TaskList taskList = taskListService.findById(id);
		return new ResponseEntity<>(taskList,HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<TaskList> addTaskList(@RequestBody TaskList taskList){
		TaskList newTaskList = taskListService.save(taskList);
		return new ResponseEntity<>(newTaskList,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<TaskList> updateTaskList(@RequestBody TaskList taskList){
		TaskList taskListUpdated = taskListService.save(taskList);
		return new ResponseEntity<>(taskListUpdated,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> updateTaskList(@PathVariable("id") Integer id){
		taskListService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
