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

import com.twodevs.MergeIt.models.entities.CheckList;
import com.twodevs.MergeIt.models.services.CheckListService;

@RestController
@RequestMapping("/checkList")
public class CheckListController {
	
	@Autowired
	CheckListService checkListService;
	
	@GetMapping("/all")
	public ResponseEntity<List<CheckList>> getCheckLists(){
		List<CheckList> checkList = checkListService.findAll();
		return new ResponseEntity<>(checkList,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CheckList> getCheckListById(@PathVariable Integer id){
		CheckList checkList = checkListService.findById(id);
		return new ResponseEntity<>(checkList,HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<CheckList> addCheckList(@RequestBody CheckList checkList){
		CheckList newCheckList = checkListService.save(checkList);
		return new ResponseEntity<>(newCheckList,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<CheckList> updateCheckList(@RequestBody CheckList checkList){
		CheckList checkListUpdated = checkListService.save(checkList);
		return new ResponseEntity<>(checkListUpdated,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> updateCheckList(@PathVariable("id") Integer id){
		checkListService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
