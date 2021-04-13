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
import com.twodevs.MergeIt.models.entities.User;
import com.twodevs.MergeIt.models.entities.dto.TeamUsersDTO;
import com.twodevs.MergeIt.models.entities.dto.UserDTO;
import com.twodevs.MergeIt.models.entities.dto.UserTeamsDTO;
import com.twodevs.MergeIt.models.services.TeamService;
import com.twodevs.MergeIt.models.services.UserService;



@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	TeamService teamService;
	
	@GetMapping("/all")
	public ResponseEntity<List<UserDTO>> getUsers(){
		List<UserDTO> user = userService.findAll().stream().map(t -> new UserDTO(t)).collect(Collectors.toList());
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping("/teamUsers/{id_team}")
	public ResponseEntity<TeamUsersDTO> getUsersByTeam(@PathVariable Integer id_team){
		Team team = teamService.findById(id_team);
		TeamUsersDTO teamUsers = new TeamUsersDTO(team);
		return new ResponseEntity<>(teamUsers,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id){
		UserDTO user = new UserDTO(userService.findById(id));
		return new ResponseEntity<>(user,HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<UserDTO> addUser(@RequestBody User user){
		UserDTO newUser = new UserDTO(userService.save(user));
		return new ResponseEntity<>(newUser,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<UserDTO> updateUser(@RequestBody User user){
		UserDTO userUpdated = new UserDTO(userService.save(user));
		return new ResponseEntity<>(userUpdated,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") Integer id){
		userService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
