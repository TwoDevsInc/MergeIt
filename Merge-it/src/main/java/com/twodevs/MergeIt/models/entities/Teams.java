package com.twodevs.MergeIt.models.entities;
// Generated 26 mar. 2021 18:34:00 by Hibernate Tools 5.2.12.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Teams generated by hbm2java
 */
@Entity
@Table(name = "teams")
public class Teams implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Date createdAt;
	private Set<Users> userses = new HashSet<Users>(0);
	private Set<Projects> projectses = new HashSet<Projects>(0);

	public Teams() {
	}

	public Teams(int id, Date createdAt) {
		this.id = id;
		this.createdAt = createdAt;
	}

	public Teams(int id, String name, Date createdAt, Set<Users> userses, Set<Projects> projectses) {
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.userses = userses;
		this.projectses = projectses;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "created_at", nullable = false, length = 13)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "teams_users", joinColumns = {
			@JoinColumn(name = "id_team", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id_user", nullable = false, updatable = false) })
	public Set<Users> getUserses() {
		return this.userses;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "teams")
	public Set<Projects> getProjectses() {
		return this.projectses;
	}

	public void setProjectses(Set<Projects> projectses) {
		this.projectses = projectses;
	}

}
