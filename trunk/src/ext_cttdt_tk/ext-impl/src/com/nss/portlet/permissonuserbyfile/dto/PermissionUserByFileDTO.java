package com.nss.portlet.permissonuserbyfile.dto;

import java.util.List;

import com.nss.portlet.filetype.model.PmlFileType;


public class PermissionUserByFileDTO {
	private long userId;
	private String account;
	private String userName;
	private List<PmlFileType> pmlFileTypeList;
	private String description;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<PmlFileType> getPmlFileTypeList() {
		return pmlFileTypeList;
	}

	public void setPmlFileTypeList(List<PmlFileType> pmlFileTypeList) {
		this.pmlFileTypeList = pmlFileTypeList;
	}

	public String getDescription() {
		return description;
	}

	public void setDescriptionList(String description) {
		this.description = description;
	}

}
