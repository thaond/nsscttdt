package com.sgs.portlet.pmluser.DTO;

public class PmlUserDTO {

	private long pmlUserId;
	private String fullName;
	private String screenName;
	private String email;
	private String positionName;
	private String departmentName;
	private String roleName;
	private String handPhone;
	private String note;
	private String teamName;
	
	public PmlUserDTO() {
	}

	public long getPmlUserId() {
		return pmlUserId;
	}

	public void setPmlUserId(long pmlUserId) {
		this.pmlUserId = pmlUserId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String rollName) {
		this.roleName = rollName;
	}

	public String getHandPhone() {
		return handPhone;
	}

	public void setHandPhone(String handPhone) {
		this.handPhone = handPhone;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

}
