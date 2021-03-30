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

import com.twodevs.MergeIt.models.entities.Team;
import com.twodevs.MergeIt.models.services.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {
	
	@Autowired
	TeamService teamService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Team>> getTeams(){
		List<Team> team = teamService.findAll();
		return new ResponseEntity<>(team,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Team> getTeamById(@PathVariable Integer id){
		Team team = teamService.findById(id);
		return new ResponseEntity<>(team,HttpStatus.OK);
	}
	
//	@GetMapping("/teamsByUser/{id_user}")
//	public ResponseEntity<List<Team>> getTeamByUserId(@PathVariable Integer id_user){
//		List<Team> teamsByUser = teamService.findByUserId(id_user);
//		return new ResponseEntity<>(teamsByUser,HttpStatus.OK);
//	}

	@PostMapping("/add")
	public ResponseEntity<Team> addTeam(@RequestBody Team team){
		Team newTeam = teamService.save(team);
		return new ResponseEntity<>(newTeam,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Team> updateTeam(@RequestBody Team team){
		Team teamUpdated = teamService.save(team);
		return new ResponseEntity<>(teamUpdated,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTeam(@PathVariable("id") Integer id){
		teamService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
