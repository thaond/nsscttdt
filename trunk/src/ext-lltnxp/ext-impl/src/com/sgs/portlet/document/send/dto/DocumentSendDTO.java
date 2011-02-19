/**
 * 
 */
package com.sgs.portlet.document.send.dto;

import java.util.Date;

/**
 * @author kienbqc
 * 
 */
public class DocumentSendDTO {
	private long documentSendId;
	private String briefContent;
	private String documentReference;
	private String receivingPlace;
	private Date issuingDate;
	private String opinion;
	private String editor;
	private String signer;
	private String documentType;
	private String privilegel;
	private String confidentialLevel;
	private Date dateCreate;
	private boolean isLocal;
	private String active;
	private String state;
	private Date sendDate;
	private String position;
	private String documentSendCode;
	private String numberPage;
	private String numberPublish;
	private String documentRecord;
	private boolean iscongvanphucdap;
	private boolean isDocOfDepartment;
	// phmphuc them thuoc tinh cho vb di phat hanh - 01/12/2010
	private long soHieuVB;
	private String phanMoRong;
	private long documentTypeId;
	private int documentRecordTypeId;
	
	public long getSoHieuVB() {
		return soHieuVB;
	}

	public void setSoHieuVB(long soHieuVB) {
		this.soHieuVB = soHieuVB;
	}

	public String getPhanMoRong() {
		return phanMoRong;
	}

	public void setPhanMoRong(String phanMoRong) {
		this.phanMoRong = phanMoRong;
	}
	
	public long getDocumentTypeId() {
		return documentTypeId;
	}
	
	public void setDocumentTypeId(long documentTypeId) {
		this.documentTypeId = documentTypeId;
	}
	
	public long getDocumentRecordTypeId() {
		return documentRecordTypeId;
	}
	
	public void setDocumentRecordTypeId(int documentRecordTypeId) {
		this.documentRecordTypeId = documentRecordTypeId;
	}
	// end phmphuc them 01/12/2010

	/**
	 * @return the numberPage
	 */
	public String getNumberPage() {
		return numberPage;
	}
	
	/**
	 * @param numberPage the numberPage to set
	 */
	public void setNumberPage(String numberPage) {
		this.numberPage = numberPage;
	}
	
	/**
	 * @return the numberPublish
	 */
	public String getNumberPublish() {
		return numberPublish;
	}
	
	/**
	 * @param numberPublish the numberPublish to set
	 */
	public void setNumberPublish(String numberPublish) {
		this.numberPublish = numberPublish;
	}

	/**
	 * @return the sendDate
	 */
	public Date getSendDate() {
		return sendDate;
	}
	
	/**
	 * @param sendDate the sendDate to set
	 */
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	
	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}
	
	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	 * @return the documentSendCode
	 */
	public String getDocumentSendCode() {
		return documentSendCode;
	}
	
	/**
	 * @param documentSendCode the documentSendCode to set
	 */
	public void setDocumentSendCode(String documentSendCode) {
		this.documentSendCode = documentSendCode;
	}

	/**
	 * @return the documentRecord
	 */
	public String getDocumentRecord() {
		return documentRecord;
	}

	
	/**
	 * @param documentRecord the documentRecord to set
	 */
	public void setDocumentRecord(String documentRecord) {
		this.documentRecord = documentRecord;
	}

	/**
	 * @return the documentSendId
	 */
	public long getDocumentSendId() {
		return documentSendId;
	}
	
	/**
	 * @param documentSendId the documentSendId to set
	 */
	public void setDocumentSendId(long documentSendId) {
		this.documentSendId = documentSendId;
	}
	
	/**
	 * @return the briefContent
	 */
	public String getBriefContent() {
		return briefContent;
	}
	
	/**
	 * @param briefContent the briefContent to set
	 */
	public void setBriefContent(String briefContent) {
		this.briefContent = briefContent;
	}
	
	/**
	 * @return the documentReference
	 */
	public String getDocumentReference() {
		return documentReference;
	}
	
	/**
	 * @param documentReference the documentReference to set
	 */
	public void setDocumentReference(String documentReference) {
		this.documentReference = documentReference;
	}
	
	/**
	 * @return the receivingPlace
	 */
	public String getReceivingPlace() {
		return receivingPlace;
	}
	
	/**
	 * @param receivingPlace the receivingPlace to set
	 */
	public void setReceivingPlace(String receivingPlace) {
		this.receivingPlace = receivingPlace;
	}
	
	/**
	 * @return the issuingDate
	 */
	public Date getIssuingDate() {
		return issuingDate;
	}
	
	/**
	 * @param issuingDate the issuingDate to set
	 */
	public void setIssuingDate(Date issuingDate) {
		this.issuingDate = issuingDate;
	}
	
	/**
	 * @return the opinion
	 */
	public String getOpinion() {
		return opinion;
	}
	
	/**
	 * @param opinion the opinion to set
	 */
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	
	/**
	 * @return the editor
	 */
	public String getEditor() {
		return editor;
	}
	
	/**
	 * @param editor the editor to set
	 */
	public void setEditor(String editor) {
		this.editor = editor;
	}
	
	/**
	 * @return the signer
	 */
	public String getSigner() {
		return signer;
	}
	
	/**
	 * @param signer the signer to set
	 */
	public void setSigner(String signer) {
		this.signer = signer;
	}
	
	/**
	 * @return the documentType
	 */
	public String getDocumentType() {
		return documentType;
	}
	
	/**
	 * @param documentType the documentType to set
	 */
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	
	/**
	 * @return the privilegel
	 */
	public String getPrivilegel() {
		return privilegel;
	}
	
	/**
	 * @param privilegel the privilegel to set
	 */
	public void setPrivilegel(String privilegel) {
		this.privilegel = privilegel;
	}
	
	/**
	 * @return the confidentialLevel
	 */
	public String getConfidentialLevel() {
		return confidentialLevel;
	}
	
	/**
	 * @param confidentialLevel the confidentialLevel to set
	 */
	public void setConfidentialLevel(String confidentialLevel) {
		this.confidentialLevel = confidentialLevel;
	}
	
	/**
	 * @return the dateCreate
	 */
	public Date getDateCreate() {
		return dateCreate;
	}
	
	/**
	 * @param dateCreate the dateCreate to set
	 */
	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}
	
	/**
	 * @return the isLocal
	 */
	public boolean getIsLocal() {
		return isLocal;
	}
	
	/**
	 * @param isLocal the isLocal to set
	 */
	public void setIsLocal(boolean isLocal) {
		this.isLocal = isLocal;
	}
	
	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}
	
	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}
	
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the iscongvanphucdap
	 */
	public boolean isIscongvanphucdap() {
		return iscongvanphucdap;
	}

	/**
	 * @param iscongvanphucdap the iscongvanphucdap to set
	 */
	public void setIscongvanphucdap(boolean iscongvanphucdap) {
		this.iscongvanphucdap = iscongvanphucdap;
	}

	public boolean isDocOfDepartment() {
		return isDocOfDepartment;
	}

	public void setDocOfDepartment(boolean isDocOfDepartment) {
		this.isDocOfDepartment = isDocOfDepartment;
	}

	public void setLocal(boolean isLocal) {
		this.isLocal = isLocal;
	}
	
	
}
