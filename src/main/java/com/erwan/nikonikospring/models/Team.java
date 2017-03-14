package com.erwan.nikonikospring.models;

import java.util.ArrayList;

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

	private String name;

	private String serial;

	@ManyToMany
	private ArrayList<Project> projects;

	@ManyToMany
	private ArrayList<User> users;

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
		return projects;
	}

	/**
	 * @param projects
	 *            the projects to set
	 */
	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}

	/**
	 * @return the users
	 */
	public ArrayList<User> getUsers() {
		return users;
	}

	/**
	 * @param users
	 *            the users to set
	 */
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public Team(String name, String serial) {
		super(Team.TABLE, Team.FIELDS);
		this.name = name;
		this.serial = serial;
		this.projects = new ArrayList<Project>();
		this.users = new ArrayList<User>();
	}

	public Team() {
		super(Team.TABLE, Team.FIELDS);
		this.projects = new ArrayList<Project>();
		this.users = new ArrayList<User>();
	}
}
