package com.twodevs.MergeIt.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twodevs.MergeIt.models.entities.Comment;

@Repository
public interface ICommentDAO extends JpaRepository<Comment, Integer> {
	List<Comment> findByTaskId(Integer id_task);
}
