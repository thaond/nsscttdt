package com.nss.portlet.department.util;

public class PmlUserDTO {
	private long id;
	private String name;
	private String position;
	private String isLeader;
	private String isDepartmentMember;
	private boolean main;
	
	public boolean isMain() {
		return main;
	}

	public void setMain(boolean main) {
		this.main = main;
	}

	public PmlUserDTO() {
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getIsLeader() {
		return isLeader;
	}
	public void setIsLeader(String isLeader) {
		this.isLeader = isLeader;
	}

	public void setIsDepartmentMember(String isDepartmentMember) {
		this.isDepartmentMember = isDepartmentMember;
	}

	public String getIsDepartmentMember() {
		return isDepartmentMember;
	}
	
}
