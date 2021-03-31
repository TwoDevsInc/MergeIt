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

import com.twodevs.MergeIt.models.entities.CheckListItem;
import com.twodevs.MergeIt.models.services.CheckListItemService;

@RestController
@RequestMapping("/checkListItem")
public class CheckListItemController {
	
	@Autowired
	CheckListItemService checkListItemService;
	
	@GetMapping("/all")
	public ResponseEntity<List<CheckListItem>> getCheckListItems(){
		List<CheckListItem> checkListItem = checkListItemService.findAll();
		return new ResponseEntity<>(checkListItem,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CheckListItem> getCheckListItemById(@PathVariable Integer id){
		CheckListItem checkListItem = checkListItemService.findById(id);
		return new ResponseEntity<>(checkListItem,HttpStatus.OK);
	}
	
	@GetMapping("/checkListItemsByCheckList/{id_check_list}")
	public ResponseEntity<List<CheckListItem>> getCheckListItemByCheckListId(@PathVariable Integer id_check_list){
		List<CheckListItem> checkListItems = checkListItemService.findByCheckListId(id_check_list);
		return new ResponseEntity<>(checkListItems,HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<CheckListItem> addCheckListItem(@RequestBody CheckListItem checkListItem){
		CheckListItem newCheckListItem = checkListItemService.save(checkListItem);
		return new ResponseEntity<>(newCheckListItem,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<CheckListItem> updateCheckListItem(@RequestBody CheckListItem checkListItem){
		CheckListItem checkListItemUpdated = checkListItemService.save(checkListItem);
		return new ResponseEntity<>(checkListItemUpdated,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> updateCheckListItem(@PathVariable("id") Integer id){
		checkListItemService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
