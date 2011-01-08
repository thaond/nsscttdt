/**
 * 
 */

package com.sgs.portlet.documentrecord.dto;

import java.util.Date;

/**
 * @author kienbqc
 */
public class DocumentRecordToDTO {

	private long documentRecordToId;
	private Date dateCreate;
	private long currentRecord;
	private String departmentName;
	private int documentRecordTypeId;
	private String documentRecordTypeName;
	private String yearlnUse;
	private String active;
	private String isAgency;
	private String agencyName;
	private String departmentOrAgency;

	/**
	 * @return the documentRecordTypeId
	 */
	public int getDocumentRecordTypeId() {
	
		return documentRecordTypeId;
	}
	
	/**
	 * @param documentRecordTypeId the documentRecordTypeId to set
	 */
	public void setDocumentRecordTypeId(int documentRecordTypeId) {
	
		this.documentRecordTypeId = documentRecordTypeId;
	}


	/**
	 * @return the documentRecodToId
	 */
	public long getDocumentRecordToId() {

		return documentRecordToId;
	}

	
	/**
	 * @return the departmentOrAgency
	 */
	public String getDepartmentOrAgency() {
	
		return departmentOrAgency;
	}

	
	/**
	 * @param departmentOrAgency the departmentOrAgency to set
	 */
	public void setDepartmentOrAgency(String departmentOrAgency) {
	
		this.departmentOrAgency = departmentOrAgency;
	}

	/**
	 * @param documentRecordToId
	 *            the documentRecodToId to set
	 */
	public void setDocumentRecordToId(long documentRecordToId) {

		this.documentRecordToId = documentRecordToId;
	}

	/**
	 * @return the dateCreate
	 */
	public Date getDateCreate() {

		return dateCreate;
	}

	/**
	 * @param dateCreate
	 *            the dateCreate to set
	 */
	public void setDateCreate(Date dateCreate) {

		this.dateCreate = dateCreate;
	}

	/**
	 * @return the currentRecord
	 */
	public long getCurrentRecord() {

		return currentRecord;
	}

	/**
	 * @param currentRecord
	 *            the currentRecord to set
	 */
	public void setCurrentRecord(long currentRecord) {

		this.currentRecord = currentRecord;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {

		return departmentName;
	}

	/**
	 * @param departmentName
	 *            the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {

		this.departmentName = departmentName;
	}

	/**
	 * @return the documentRecordTypeName
	 */
	public String getDocumentRecordTypeName() {

		return documentRecordTypeName;
	}

	/**
	 * @param documentRecordTypeName
	 *            the documentRecordTypeName to set
	 */
	public void setDocumentRecordTypeName(String documentRecordTypeName) {

		this.documentRecordTypeName = documentRecordTypeName;
	}

	/**
	 * @return the yearlnUse
	 */
	public String getYearlnUse() {

		return yearlnUse;
	}

	/**
	 * @param yearlnUse
	 *            the yearlnUse to set
	 */
	public void setYearlnUse(String yearlnUse) {

		this.yearlnUse = yearlnUse;
	}

	/**
	 * @return the active
	 */
	public String getActive() {

		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(String active) {

		this.active = active;
	}

	/**
	 * @return the isAgency
	 */
	public String getIsAgency() {

		return isAgency;
	}

	/**
	 * @param isAgency
	 *            the isAgency to set
	 */
	public void setIsAgency(String isAgency) {

		this.isAgency = isAgency;
	}

	/**
	 * @return the agencyName
	 */
	public String getAgencyName() {

		return agencyName;
	}

	/**
	 * @param agencyName
	 *            the agencyName to set
	 */
	public void setAgencyName(String agencyName) {

		this.agencyName = agencyName;
	}
}
