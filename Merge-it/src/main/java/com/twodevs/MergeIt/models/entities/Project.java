package com.twodevs.MergeIt.models.entities;
// Generated 26 mar. 2021 18:34:00 by Hibernate Tools 5.2.12.Final

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Projects generated by hbm2java
 */
@Entity
@Table(name = "projects")
public class Project implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	@JsonIgnoreProperties({"users","projects","hibernateLazyInitializer", "handler"})  
	private Team team;
	private String name;
	private LocalDate createdAt;
	@JsonIgnore
	private Set<TaskList> taskLists = new HashSet<TaskList>(0);

	public Project() {
	}

	public Project(int id, Team team, LocalDate createdAt) {
		this.id = id;
		this.team = team;
		this.createdAt = createdAt;
	}

	public Project(int id, Team team, String name, LocalDate createdAt, Set<TaskList> taskLists) {
		this.id = id;
		this.team = team;
		this.name = name;
		this.createdAt = createdAt;
		this.taskLists = taskLists;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_team", nullable = false)
	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "created_at", nullable = false, length = 13)
	public LocalDate getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	public Set<TaskList> getTaskLists() {
		return this.taskLists;
	}

	public void setTaskLists(Set<TaskList> taskLists) {
		this.taskLists = taskLists;
	}

}
