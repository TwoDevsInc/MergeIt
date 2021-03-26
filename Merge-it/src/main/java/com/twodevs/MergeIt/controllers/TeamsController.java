package com.twodevs.MergeIt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twodevs.MergeIt.models.entities.Teams;
import com.twodevs.MergeIt.models.services.TeamsService;

@RestController
@RequestMapping("/teams")
public class TeamsController {
	
	@Autowired
	TeamsService teamService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Teams>> getTeams(){
		List<Teams> teams = teamService.findAll();
		return new ResponseEntity<>(teams,HttpStatus.OK);
	}

}
