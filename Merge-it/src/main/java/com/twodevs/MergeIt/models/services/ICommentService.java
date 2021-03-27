package com.twodevs.MergeIt.models.services;

import java.util.List;

import com.twodevs.MergeIt.models.entities.Comment;



public interface ICommentService {
	public List<Comment> findAll();

    public Comment save(Comment comment);

    public Comment findById(Integer id);

    public void delete(Comment comment);

    public void deleteById(Integer id);
}
