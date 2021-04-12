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

import com.twodevs.MergeIt.models.entities.CheckList;
import com.twodevs.MergeIt.models.entities.TaskList;
import com.twodevs.MergeIt.models.entities.dto.CheckListDTO;
import com.twodevs.MergeIt.models.services.CheckListService;

@RestController
@RequestMapping("/checkList")
public class CheckListController {
	
	@Autowired
	CheckListService checkListService;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<CheckListDTO>> getCheckLists(){
		List<CheckListDTO> checkList = checkListService.findAll().stream().map(c -> new CheckListDTO(c)).collect(Collectors.toList());
		return new ResponseEntity<>(checkList,HttpStatus.OK);
	}
	
	@GetMapping("/checkListsByTask/{id_task}")
	public ResponseEntity<List<CheckListDTO>> getCheckListsByTaskId(@PathVariable Integer id_task){
		List<CheckListDTO> checkLists = checkListService.findByTaskId(id_task).stream().map(c -> new CheckListDTO(c)).collect(Collectors.toList());
		return new ResponseEntity<>(checkLists,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CheckListDTO> getCheckListById(@PathVariable Integer id){
		CheckListDTO checkList = new CheckListDTO(checkListService.findById(id));
		return new ResponseEntity<>(checkList,HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<CheckListDTO> addCheckList(@RequestBody CheckList checkList){
		CheckListDTO newCheckList = new CheckListDTO(checkListService.save(checkList));
		return new ResponseEntity<>(newCheckList,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<CheckListDTO> updateCheckList(@RequestBody CheckList checkList){
		CheckListDTO checkListUpdated = new CheckListDTO(checkListService.save(checkList));
		return new ResponseEntity<>(checkListUpdated,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> updateCheckList(@PathVariable("id") Integer id){
		checkListService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
