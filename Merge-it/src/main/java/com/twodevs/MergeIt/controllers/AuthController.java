package com.twodevs.MergeIt.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twodevs.MergeIt.models.entities.AuthRequest;
import com.twodevs.MergeIt.models.entities.AuthResponse;
import com.twodevs.MergeIt.models.entities.User;
import com.twodevs.MergeIt.models.entities.dto.UserDTO;
import com.twodevs.MergeIt.models.entities.dto.UserRegisterDTO;
import com.twodevs.MergeIt.models.services.UserService;
import com.twodevs.MergeIt.security.MyUserDetailsService;
import com.twodevs.MergeIt.security.util.JWTUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JWTUtil jwtTokenUtil;	
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody UserRegisterDTO user){
		user.setRegisterDate(LocalDate.now());
		userService.save(new User(user));
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> createAuthenticationToken(@RequestBody AuthRequest authenticationRequest) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
							authenticationRequest.getUsername(), 
							authenticationRequest.getPassword()
							)
					);
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		UserDTO userLogged = new UserDTO(userService.findByUsername(userDetails.getUsername()));
		return new ResponseEntity<>(new AuthResponse(jwt,userLogged),HttpStatus.OK);
	}
	
	@GetMapping("/validateToken")
	public void validateToken() {}
	

}
