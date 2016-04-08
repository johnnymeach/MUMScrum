package org.mum.scrum.entities;
// Generated Apr 7, 2016 10:07:25 PM by Hibernate Tools 3.6.0.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Sprints generated by hbm2java
 */
@Entity
@Table(name = "sprints", catalog = "mumscrum_prod")
public class Sprints implements java.io.Serializable {

	private Integer id;
	private Projects projects;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private Boolean status;
	private Date assignedDate;
	private Set<Userstory> userstories = new HashSet<Userstory>(0);

	public Sprints() {
	}

	public Sprints(Projects projects, String name, String description, Date startDate, Date endDate, Boolean status,
			Date assignedDate, Set<Userstory> userstories) {
		this.projects = projects;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.assignedDate = assignedDate;
		this.userstories = userstories;
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
	@JoinColumn(name = "project_id")
	public Projects getProjects() {
		return this.projects;
	}

	public void setProjects(Projects projects) {
		this.projects = projects;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "startDate", length = 10)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "endDate", length = 10)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "status")
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "assignedDate", length = 10)
	public Date getAssignedDate() {
		return this.assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sprints")
	public Set<Userstory> getUserstories() {
		return this.userstories;
	}

	public void setUserstories(Set<Userstory> userstories) {
		this.userstories = userstories;
	}

}
