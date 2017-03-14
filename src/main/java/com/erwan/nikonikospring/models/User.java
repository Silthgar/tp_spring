package com.erwan.nikonikospring.models;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.erwan.nikonikospring.models.security.SecurityUser;

//les annotations ci-dessous indiquent que la classe user représente un objet de la BDD qui
//sera une table nommee "user"
//ATTENTION : @Table sans @Entity n'est pas permis
@Entity
@Table(name = "user")
public class User extends SecurityUser {

    public static final char SEX_MALE = 'M';
    public static final char SEX_FEMALE = 'F';
    public static final char SEX_UNDEFINNED = 'U';

	@Transient
	public static final String TABLE = "user";

	@Transient
	public static final String[] FIELDS = { "id", "login", "password", "sex", "lastname", "firstname",
			"registration_cgi" };

	@Column(nullable = false)
	private String lastname;

	@Column(nullable = false)
	private String firstname;

	@Column(nullable = false)
	private String registration_cgi;

	//annotation qui indique la relation entre les tables (1,n ; 1,1 ; n,n)
	@OneToMany
	private Set<NikoNiko> nikoNikos;

	@ManyToMany
	private Set<Team> teams;

	@Column(nullable = false)
	private char sex;

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @return the sex
	 */
	public char getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(char sex) {
	    switch (sex) {
	    case User.SEX_MALE:
	    case User.SEX_FEMALE:
	    case User.SEX_UNDEFINNED:
	        this.sex = sex;
	        break;
        default:
            throw new InvalidParameterException();
	    }
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the registration_cgi
	 */
	public String getRegistration_cgi() {
		return registration_cgi;
	}

	/**
	 * @param registration_cgi
	 *            the registration_cgi to set
	 */
	public void setRegistration_cgi(String registration_cgi) {
		this.registration_cgi = registration_cgi;
	}

	/**
	 * @return the nikoNikos
	 */
	public ArrayList<NikoNiko> getNikoNikos() {
		return (ArrayList<NikoNiko>)nikoNikos;
	}

	/**
	 * @param nikoNikos
	 *            the nikoNikos to set
	 */
	public void setNikoNikos(ArrayList<NikoNiko> nikoNikos) {
		this.nikoNikos = (Set)nikoNikos;
	}

	/**
	 * @return the teams
	 */
	public ArrayList<Team> getTeams() {
		return (ArrayList<Team>)teams;
	}

	/**
	 * @param teams
	 *            the teams to set
	 */
	public void setTeams(ArrayList<Team> teams) {
		this.teams = (Set)teams;
	}

	public User(String login, String password, String lastname, String firstname, String registration_cgi) {
		super(User.TABLE, User.FIELDS, login, password);
		this.lastname = lastname;
		this.firstname = firstname;
		this.registration_cgi = registration_cgi;
	}

	public User() {
		super(User.TABLE, User.FIELDS);
	}

	public User(String firstname, String lastname) {
		this(firstname, lastname, 'I');
	}

	public User(String firstname, String lastname, char sex) {
		super(User.TABLE, User.FIELDS);
		this.lastname = lastname;
		this.firstname = firstname;
		this.sex = sex;
	}
}
