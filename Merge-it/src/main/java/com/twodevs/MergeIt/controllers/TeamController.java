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

import com.twodevs.MergeIt.models.entities.Team;
import com.twodevs.MergeIt.models.entities.dto.TaskListDTO;
import com.twodevs.MergeIt.models.entities.dto.TeamDTO;
import com.twodevs.MergeIt.models.services.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {
	
	@Autowired
	TeamService teamService;
	
	@GetMapping("/all")
	public ResponseEntity<List<TeamDTO>> getTeams(){
		List<TeamDTO> team = teamService.findAll().stream().map(t -> new TeamDTO(t)).collect(Collectors.toList());
		return new ResponseEntity<>(team,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TeamDTO> getTeamById(@PathVariable Integer id){
		TeamDTO team = new TeamDTO(teamService.findById(id));
		return new ResponseEntity<>(team,HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<TeamDTO> addTeam(@RequestBody Team team){
		TeamDTO newTeam = new TeamDTO(teamService.save(team));
		return new ResponseEntity<>(newTeam,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<TeamDTO> updateTeam(@RequestBody Team team){
		TeamDTO teamUpdated = new TeamDTO(teamService.save(team));
		return new ResponseEntity<>(teamUpdated,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTeam(@PathVariable("id") Integer id){
		teamService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
