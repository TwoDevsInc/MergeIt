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

import com.twodevs.MergeIt.models.entities.Task;
import com.twodevs.MergeIt.models.entities.TaskList;
import com.twodevs.MergeIt.models.services.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

	
	@Autowired
	TaskService taskService;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Task>> getTasks(){
		List<Task> task = taskService.findAll();
		return new ResponseEntity<>(task, HttpStatus.OK);
	}
	
	@GetMapping("/tasksByTaskList/{id_task_list}")
	public ResponseEntity<List<Task>> getTaskByTaskListId(@PathVariable Integer id_task_list){
		List<Task> tasks = taskService.findByTaskListId(id_task_list);
		return new ResponseEntity<>(tasks,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable Integer id){
		Task task = taskService.findById(id);
		return new ResponseEntity<>(task, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Task> addTask(@RequestBody Task task){
		Task newTask = taskService.save(task);
		return new ResponseEntity<>(newTask, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Task> update(@RequestBody Task task){
		Task updatedTask = taskService.save(task);
		return new ResponseEntity<>(updatedTask, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable("id") Integer id){
		taskService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
