package com.nss.portlet.documentfield.util;

import com.nss.portlet.department.model.Department;
import com.nss.portlet.department.service.DepartmentLocalServiceUtil;
import com.nss.portlet.documentfield.model.PmlField;


public class DocumentFieldDTO {
	private String id;
	private String code;
	private String name;
	private String departmentName;
	private String description;
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	
	public static DocumentFieldDTO convertDocumentFieldToDTO (PmlField documentField) throws Exception {
		DocumentFieldDTO documentFieldDTO = new DocumentFieldDTO();
		
		Department department = DepartmentLocalServiceUtil.getDepartment(documentField.getDepartmentsId());
		String departmentName = department.getDepartmentsName();
		
		documentFieldDTO.setId(documentField.getFieldId());
		documentFieldDTO.setCode(documentField.getFieldCode());
		documentFieldDTO.setName(documentField.getFieldName());
		documentFieldDTO.setDepartmentName(departmentName);
		documentFieldDTO.setDescription(documentField.getDescription());
		
		return documentFieldDTO;
	}
}
