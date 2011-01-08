/**
 * 
 */

package com.sgs.portlet.onedoor.dto;

import java.util.Date;

/**
 * @author kienbqc
 */
public class PmlFileDTO {

	private String fileId;
	private String district;
	private String filetype;
	private Date expectedReturingDate;
	private Date applicationDate;
	private String otherContent;
	private String briefContent;
	private String applicantName;
	private String organization;
	private String authourisedLetter;
	private String idNumber;
	private Date issuingDate;
	private String issuingPlace;
	private String telephone;
	private String gender;
	private String contactInformation;
	private String numberReceipt;
	private String field;
	private int solvingTime;
	private String note;
	private String receiver;
	private Date dateCreate;
	private String permanentAddress;
	private String status;
	private long generalorderno;
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPermanentAddress() {
		return permanentAddress;
	}


	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}


	public String getReceiver() {
	
		return receiver;
	}

	
	public void setReceiver(String receiver) {
	
		this.receiver = receiver;
	}

	
	public Date getDateCreate() {
	
		return dateCreate;
	}

	
	public void setDateCreate(Date dateCreate) {
	
		this.dateCreate = dateCreate;
	}

	private String address;

	public String getFileId() {

		return fileId;
	}

	public void setFileId(String fileId) {

		this.fileId = fileId;
	}

	public int getSolvingTime() {
		
		return solvingTime;
	}

	
	public void setSolvingTime(int solvingTime) {
	
		this.solvingTime = solvingTime;
	}
	
	public Date getApplicationDate() {

		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {

		this.applicationDate = applicationDate;
	}

	public String getDistrict() {

		return district;
	}

	public void setDistrict(String district) {

		this.district = district;
	}

	public String getFiletype() {

		return filetype;
	}

	public void setFiletype(String filetype) {

		this.filetype = filetype;
	}

	public Date getExpectedReturingDate() {

		return expectedReturingDate;
	}

	public void setExpectedReturingDate(Date expectedReturingDate) {

		this.expectedReturingDate = expectedReturingDate;
	}

	public String getOtherContent() {

		return otherContent;
	}

	public void setOtherContent(String otherContent) {

		this.otherContent = otherContent;
	}

	public String getBriefContent() {

		return briefContent;
	}

	public void setBriefContent(String briefContent) {

		this.briefContent = briefContent;
	}

	public String getApplicantName() {

		return applicantName;
	}

	public void setApplicantName(String applicantName) {

		this.applicantName = applicantName;
	}

	public String getOrganization() {

		return organization;
	}

	public void setOrganization(String organization) {

		this.organization = organization;
	}

	public String getAuthourisedLetter() {

		return authourisedLetter;
	}

	public void setAuthourisedLetter(String authourisedLetter) {

		this.authourisedLetter = authourisedLetter;
	}

	public String getIdNumber() {

		return idNumber;
	}

	public void setIdNumber(String idNumber) {

		this.idNumber = idNumber;
	}

	public Date getIssuingDate() {

		return issuingDate;
	}

	public void setIssuingDate(Date issuingDate) {

		this.issuingDate = issuingDate;
	}

	public String getIssuingPlace() {

		return issuingPlace;
	}

	public void setIssuingPlace(String issuingPlace) {

		this.issuingPlace = issuingPlace;
	}

	public String getTelephone() {

		return telephone;
	}

	public void setTelephone(String telephone) {

		this.telephone = telephone;
	}

	public String getGender() {

		return gender;
	}

	public void setGender(String gender) {

		this.gender = gender;
	}

	public String getContactInformation() {

		return contactInformation;
	}

	public void setContactInformation(String contactInformation) {

		this.contactInformation = contactInformation;
	}

	public String getNumberReceipt() {

		return numberReceipt;
	}

	public void setNumberReceipt(String numberReceipt) {

		this.numberReceipt = numberReceipt;
	}

	public String getField() {

		return field;
	}

	public void setField(String field) {

		this.field = field;
	}

	public String getNote() {

		return note;
	}

	public void setNote(String note) {

		this.note = note;
	}

	public String getAddress() {

		return address;
	}

	public void setAddress(String address) {

		this.address = address;
	}

	public long getGeneralorderno() {
		return generalorderno;
	}

	public void setGeneralorderno(long generalorderno) {
		this.generalorderno = generalorderno;
	}

}
