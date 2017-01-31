package com.infosys.continuousintegration.dto;

public class Details {
	
	Details()
	{
		this.displayname = displayname;
		this.projectId = projectId;
	}
	
	String displayname;
	String projectId;
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	

}
