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

import com.twodevs.MergeIt.models.entities.Task;
import com.twodevs.MergeIt.models.entities.TaskList;
import com.twodevs.MergeIt.models.entities.dto.TaskDTO;
import com.twodevs.MergeIt.models.services.TaskListService;
import com.twodevs.MergeIt.models.services.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

	
	@Autowired
	TaskService taskService;
	
	@Autowired
	TaskListService taskListService;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<TaskDTO>> getTasks(){
		List<TaskDTO> task = taskService.findAll().stream().map(t -> new TaskDTO(t)).collect(Collectors.toList());
		return new ResponseEntity<>(task, HttpStatus.OK);
	}
	
	@GetMapping("/tasksByTaskList/{id_task_list}")
	public ResponseEntity<List<TaskDTO>> getTaskByTaskListId(@PathVariable Integer id_task_list){
		List<TaskDTO> tasks = taskService.findByTaskListId(id_task_list).stream().map(t -> new TaskDTO(t)).collect(Collectors.toList());
		return new ResponseEntity<>(tasks,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TaskDTO> getTaskById(@PathVariable Integer id){
		TaskDTO task = new TaskDTO(taskService.findById(id));
		return new ResponseEntity<>(task, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<TaskDTO> addTask(@RequestBody Task task){
		TaskDTO newTask = new TaskDTO(taskService.save(task));
		return new ResponseEntity<>(newTask, HttpStatus.CREATED);
	}
	
	@PostMapping("/addTaskTo/{id_task_list}")
	public ResponseEntity<TaskDTO> addTask(@RequestBody Task task, @PathVariable Integer id_task_list){
		
		TaskList taskList = taskListService.findById(id_task_list);		
		task.setTaskList(taskList);
		
		TaskDTO newTask = new TaskDTO(taskService.save(task));
		return new ResponseEntity<>(newTask, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<TaskDTO> update(@RequestBody Task task){
		TaskDTO updatedTask = new TaskDTO(taskService.save(task));
		return new ResponseEntity<>(updatedTask, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable("id") Integer id){
		taskService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
