package com.erwan.nikonikospring.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.erwan.nikonikospring.models.base.DatabaseItem;

@Entity
@Table(name = "project")
public class Project extends DatabaseItem {

	@Transient
	public static final String TABLE = "project";

	@Transient
	public static final String[] FIELDS = { "id", "name", "start_Date", "end_Date" };

	@Column(nullable = false)
	private String name;

	@Column(nullable=true)
	private Date start_date;

	@Column(nullable=true)
	private Date end_date;

	@OneToMany
	private Set<NikoNiko> nikoNikos;

	@ManyToMany
	private Set<Team> teams;

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
	 * @return the start_date
	 */
	public Date getStart_date() {
		return start_date;
	}

	/**
	 * @param start_date
	 *            the start_date to set
	 */
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	/**
	 * @return the end_date
	 */
	public Date getEnd_date() {
		return end_date;
	}

	/**
	 * @param end_date
	 *            the end_date to set
	 */
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	/**
	 * @return the nikoNikos
	 */
	public ArrayList<NikoNiko> getNikoNikos() {
		return (ArrayList<NikoNiko>) nikoNikos;
	}

	/**
	 * @param nikoNikos
	 *            the nikoNikos to set
	 */
	public void setNikoNikos(ArrayList<NikoNiko> nikoNikos) {
		this.nikoNikos = (Set<NikoNiko>) nikoNikos;
	}

	/**
	 * @return the teams
	 */
	public ArrayList<Team> getTeams() {
		return (ArrayList<Team>) teams;
	}

	/**
	 * @param teams
	 *            the teams to set
	 */
	public void setTeams(ArrayList<Team> teams) {
		this.teams = (Set<Team>) teams;
	}

	public Project(String name, Date start_date) {
		super(Project.TABLE, Project.FIELDS);
		this.name = name;
		this.start_date = start_date;
	}

	public Project(String name, Date start_date, Date end_date) {
		super(Project.TABLE, Project.FIELDS);
		this.name = name;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public Project() {
		super(Project.TABLE, Project.FIELDS);
	}
}
