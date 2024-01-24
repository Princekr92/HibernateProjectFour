package com.map1;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Emp {

	@Id
	private int eid;
	private String employeName;
	
	@ManyToMany
	private List<Project>projects;

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(int eid, String employeName, List<Project> projects) {
		super();
		this.eid = eid;
		this.employeName = employeName;
		this.projects = projects;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEmployeName() {
		return employeName;
	}

	public void setEmployeName(String employeName) {
		this.employeName = employeName;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
}
