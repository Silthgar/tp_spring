package com.erwan.nikonikospring.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.erwan.nikonikospring.models.modelbase.DatabaseItem;

@Entity
@Table(name = "project")
public class Project extends DatabaseItem {

	@Transient
	public static final String TABLE = "project";
	@Transient
	public static final String[] FIELDS = { "id", "name", "start_Date", "end_Date" };

	@Column(name = "project_name", nullable = false)
	private String name;
	@Column(name = "project_start_date", nullable = false)
	private Date start_date;
	@Column(name = "project_end_date", nullable = true)
	private Date end_date;

	@OneToMany(targetEntity = NikoNiko.class)
	private Set<NikoNiko> nikoNikos;
	@ManyToMany(targetEntity = Team.class)
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
	public Set<NikoNiko> getNikoNikos() {
		return nikoNikos;
	}

	/**
	 * @param nikoNikos
	 *            the nikoNikos to set
	 */
	public void setNikoNikos(Set<NikoNiko> nikoNikos) {
		this.nikoNikos = nikoNikos;
	}

	/**
	 * @return the teams
	 */
	public Set<Team> getTeams() {
		return teams;
	}

	/**
	 * @param teams
	 *            the teams to set
	 */
	public void setTeams(Set<Team> teams) {
		this.teams = teams;
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
