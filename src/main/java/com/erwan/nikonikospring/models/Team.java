package com.erwan.nikonikospring.models;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.erwan.nikonikospring.models.base.DatabaseItem;

@Entity
@Table(name = "team")
public class Team extends DatabaseItem {

	@Transient
	public static final String TABLE = "team";

	@Transient
	public static final String[] FIELDS = { "id", "name", "serial" };

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String serial;

	@ManyToMany
	private Set<Project> projects;

	@ManyToMany
	private Set<User> users;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the serial
	 */
	public String getSerial() {
		return serial;
	}

	/**
	 * @param serial
	 *            the serial to set
	 */
	public void setSerial(String serial) {
		this.serial = serial;
	}

	/**
	 * @return the projects
	 */
	public ArrayList<Project> getProjects() {
		return (ArrayList<Project>) projects;
	}

	/**
	 * @param projects
	 *            the projects to set
	 */
	public void setProjects(ArrayList<Project> projects) {
		this.projects = (Set) projects;
	}

	/**
	 * @return the users
	 */
	public ArrayList<User> getUsers() {
		return (ArrayList<User>) users;
	}

	/**
	 * @param users
	 *            the users to set
	 */
	public void setUsers(ArrayList<User> users) {
		this.users = (Set) users;
	}

	public Team(String name, String serial) {
		super(Team.TABLE, Team.FIELDS);
		this.name = name;
		this.serial = serial;
	}

	public Team() {
		super(Team.TABLE, Team.FIELDS);
	}
}
