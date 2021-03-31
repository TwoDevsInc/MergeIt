package com.twodevs.MergeIt.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twodevs.MergeIt.models.dao.ICommentDAO;
import com.twodevs.MergeIt.models.entities.Comment;

@Service
public class CommentService implements ICommentService {

	@Autowired
	ICommentDAO commentDAO;
	
	@Override
	public List<Comment> findAll() {
		return commentDAO.findAll();
	}
	
	@Override
	public List<Comment> findByTaskId(Integer id_task) {
		return commentDAO.findByTaskId(id_task);
	}

	@Override
	public Comment save(Comment comment) {
		return commentDAO.save(comment);
	}

	@Override
	public Comment findById(Integer id) {
		return commentDAO.findById(id).orElse(null);
	}

	@Override
	public void delete(Comment comment) {
		commentDAO.delete(comment);
	}

	@Override
	public void deleteById(Integer id) {
		commentDAO.deleteById(id);
	}

	

}
