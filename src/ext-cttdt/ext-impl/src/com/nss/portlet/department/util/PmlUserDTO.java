package com.nss.portlet.department.util;

public class PmlUserDTO {
	private long id;
	private long userId;
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	private String name;
	private String position;
	private String isLeader;
	private String isDepartmentMember;
	private String screenName;
	private String lastName;
	private String middleName;
	private String firstName;
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

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
}
