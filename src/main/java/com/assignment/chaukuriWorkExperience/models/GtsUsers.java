package com.assignment.chaukuriWorkExperience.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "GTS_USERS")
public class GtsUsers {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("GTS_USER_ID")
	@Column(name = "GTS_USER_ID", nullable = false)
	private long gtsUserId;
	@JsonProperty("GTS_USER_EMAIL")
	@Column(name = "GTS_USER_EMAIL", nullable = false)
	private String gtsUserEmail;
	@JsonProperty("GTS_USER_PASSWORD")
	@Column(name = "GTS_USER_PASSWORD", nullable = false)
	private String gtsUserPassword;

	@JsonProperty("GTS_USER_LOGIN_TRIES")
	@Column(name = "GTS_USER_LOGIN_TRIES", nullable = false)
	private Integer gtsUserLoginTries;
	@JsonProperty("GTS_USER_STATUS")
	@Column(name = "GTS_USER_STATUS", nullable = false)
	private Boolean gtsUserStatus;

	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "gtsUser")
	private Set<GtsUserProjects> GtsUserProjectsset = new HashSet<>();
	public Set<GtsUserProjects> getGtsUserProjectsset() {
		return GtsUserProjectsset;
	}

	public void setGtsUserProjectsset(Set<GtsUserProjects> gtsUserProjectsset) {
		GtsUserProjectsset = gtsUserProjectsset;
	}

	public GtsUsers(Integer gtsUserId, String gtsUserEmail, String gtsUserPassword, String gtsUserFirstName,
			String gtsUserLastName, Boolean gtsUserLoginTries, Boolean gtsUserStatus, String gtsUserMobile,
			Boolean gtsIsMobileValidated) {
		super();
		this.gtsUserId = gtsUserId;
		this.gtsUserEmail = gtsUserEmail;
		this.gtsUserPassword = gtsUserPassword;
		this.gtsUserStatus = gtsUserStatus;

		
	}

	public long getGtsUserId() {
		return gtsUserId;
	}

	public void setGtsUserId(long gtsUserId) {
		this.gtsUserId = gtsUserId;
	}

	public String getGtsUserEmail() {
		return gtsUserEmail;
	}

	public void setGtsUserEmail(String gtsUserEmail) {
		this.gtsUserEmail = gtsUserEmail;
	}

	public String getGtsUserPassword() {
		return gtsUserPassword;
	}

	public void setGtsUserPassword(String gtsUserPassword) {
		this.gtsUserPassword = gtsUserPassword;
	}

	public Integer getGtsUserLoginTries() {
		return gtsUserLoginTries;
	}

	public void setGtsUserLoginTries(Integer gtsUserLoginTries) {
		this.gtsUserLoginTries = gtsUserLoginTries;
	}

	public Boolean getGtsUserStatus() {
		return gtsUserStatus;
	}

	public void setGtsUserStatus(Boolean gtsUserStatus) {
		this.gtsUserStatus = gtsUserStatus;
	}

	public GtsUsers() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "GtsUsers [gtsUserId=" + gtsUserId + ", gtsUserEmail=" + gtsUserEmail + ", gtsUserPassword="
				+ gtsUserPassword + ", gtsUserLoginTries=" + gtsUserLoginTries + ", gtsUserStatus=" + gtsUserStatus
				+ ", GtsUserWorkExperienceSET=" + "]";
	}
}
