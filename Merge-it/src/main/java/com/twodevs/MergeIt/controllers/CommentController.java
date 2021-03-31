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

import com.twodevs.MergeIt.models.entities.Comment;
import com.twodevs.MergeIt.models.services.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Comment>> getComments(){
		List<Comment> comment = commentService.findAll();
		return new ResponseEntity<>(comment, HttpStatus.OK);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Comment> getCommentById(@PathVariable Integer id){
		Comment comment = commentService.findById(id);
		return new ResponseEntity<>(comment, HttpStatus.OK);
	}
	
	@GetMapping("/commentsByTask/{id_task}")
	public ResponseEntity<List<Comment>> getCommentByTaskId(@PathVariable Integer id_task){
		List<Comment> comments = commentService.findByTaskId(id_task);
		return new ResponseEntity<>(comments, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Comment> addComment(@RequestBody Comment comment){
		Comment newComment = commentService.save(comment);
		return new ResponseEntity<>(newComment, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Comment> updateComment(@RequestBody Comment comment){
		Comment commentUpdated = commentService.save(comment);
		return new ResponseEntity<>(commentUpdated, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> updateComment(@PathVariable("id") Integer id){
		commentService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
