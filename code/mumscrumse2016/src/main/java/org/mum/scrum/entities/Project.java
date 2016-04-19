package org.mum.scrum.entities;
// Generated Apr 9, 2016 12:05:30 PM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Project generated by hbm2java
 */
@Entity
@Table(name = "projects")
public class Project implements java.io.Serializable {

	private Integer id;
	private User user;
	private String name;
	private String description;
	private Set<Sprint> sprints = new HashSet<Sprint>(0);

	public Project() {
	}

	public Project(User user, String name, String description, Set<Sprint> sprints) {
		this.user = user;
		this.name = name;
		this.description = description;
		this.sprints = sprints;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 256)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonBackReference
	public Set<Sprint> getSprints() {
		return this.sprints;
	}

	public void setSprints(Set<Sprint> sprints) {
		this.sprints = sprints;
	}

}
