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
import com.twodevs.MergeIt.models.entities.CheckListItem;
import com.twodevs.MergeIt.models.entities.Task;
import com.twodevs.MergeIt.models.entities.dto.CheckListDTO;
import com.twodevs.MergeIt.models.entities.dto.CheckListItemDTO;
import com.twodevs.MergeIt.models.services.CheckListItemService;
import com.twodevs.MergeIt.models.services.CheckListService;

@RestController
@RequestMapping("/checkListItem")
public class CheckListItemController {
	
	@Autowired
	CheckListItemService checkListItemService;
	
	@Autowired
	CheckListService checkListService;
	
	@GetMapping("/all")
	public ResponseEntity<List<CheckListItemDTO>> getCheckListItems(){
		List<CheckListItemDTO> checkListItem = checkListItemService.findAll().stream().map(i -> new CheckListItemDTO(i)).collect(Collectors.toList());
		return new ResponseEntity<>(checkListItem,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CheckListItemDTO> getCheckListItemById(@PathVariable Integer id){
		CheckListItemDTO checkListItem = new CheckListItemDTO(checkListItemService.findById(id));
		return new ResponseEntity<>(checkListItem,HttpStatus.OK);
	}
	
	@GetMapping("/checkListItemsByCheckList/{id_check_list}")
	public ResponseEntity<List<CheckListItemDTO>> getCheckListItemByCheckListId(@PathVariable Integer id_check_list){
		List<CheckListItemDTO> checkListItems = checkListItemService.findByCheckListId(id_check_list).stream().map(i -> new CheckListItemDTO(i)).collect(Collectors.toList());
		return new ResponseEntity<>(checkListItems,HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<CheckListItemDTO> addCheckListItem(@RequestBody CheckListItem checkListItem){
		CheckListItemDTO newCheckListItem = new CheckListItemDTO(checkListItemService.save(checkListItem));
		return new ResponseEntity<>(newCheckListItem,HttpStatus.CREATED);
	}
	
	@PostMapping("/addCheckListItemTo/{id_check_list}")
	public ResponseEntity<CheckListItemDTO> addFileToTask(@RequestBody CheckListItem checkListItem,@PathVariable Integer id_check_list){
		
		CheckList checkList = checkListService.findById(id_check_list);
		checkListItem.setChecklist(checkList);
		
		CheckListItemDTO newCheckListItem = new CheckListItemDTO(checkListItemService.save(checkListItem));
		return new ResponseEntity<>(newCheckListItem, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<CheckListItemDTO> updateCheckListItem(@RequestBody CheckListItem checkListItem){
		CheckListItemDTO checkListItemUpdated = new CheckListItemDTO(checkListItemService.save(checkListItem));
		return new ResponseEntity<>(checkListItemUpdated,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> updateCheckListItem(@PathVariable("id") Integer id){
		checkListItemService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
