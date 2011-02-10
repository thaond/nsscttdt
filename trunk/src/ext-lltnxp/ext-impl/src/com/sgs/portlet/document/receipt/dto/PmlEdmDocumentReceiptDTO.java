/**
 * 
 */
package com.sgs.portlet.document.receipt.dto;

import java.util.Date;

/**
 * PmlEdmDocumentReceiptDTO is a data transfer object. It is a instance of
 * document receipt. It carry data to show information in jsp page.
 * 
 * @version 1.4 10 Apr 2009
 * @author kienbqc
 */
public class PmlEdmDocumentReceiptDTO {
	private long documentReceiptId; // ma cong van den
	private String documentReference; // so hieu cong van den
	private String numberLocalDocumentReceipt; // so cong van noi bo
	private String numberDocumentReceipt; // so cong van noi bo
	private String issuingPlaceName; // co quan phat hanh
	private Date isuuingDate; // ngay phat hanh
	private String signer; // nguoi ky
	private Date dateArrive; // ngay den
	private int processTime; // so ngay xu ly
	private String isPublic; // cong van cong khai
	private String levelSendName; // cap goi
	private String documentTypeName;// loai cong van
	private String confidentialLevelName; // do mat
	private String privilegeLevel; // do khan
	private String briefContent;// trich yeu
	private String state; // trang thai
	private String thoigiannhancvden;
	
	private String donViSaoY;
	private long documentTypeId;
	private int documentRecordTypeId;

	private String socongvandiphucdap;

	public String getSocongvandiphucdap() {
		return socongvandiphucdap;
	}

	public void setSocongvandiphucdap(String socongvandiphucdap) {
		this.socongvandiphucdap = socongvandiphucdap;
	}

	/**
	 * @return the numberDocumentReceipt
	 */
	public String getNumberDocumentReceipt() {

		return numberDocumentReceipt;
	}

	/**
	 * @param numberDocumentReceipt
	 *            the numberDocumentReceipt to set
	 */
	public void setNumberDocumentReceipt(String numberDocumentReceipt) {

		this.numberDocumentReceipt = numberDocumentReceipt;
	}

	/**
	 * @return the documentReceiptId
	 */
	public long getDocumentReceiptId() {

		return documentReceiptId;
	}

	/**
	 * @param documentReceiptId
	 *            the documentReceiptId to set
	 */
	public void setDocumentReceiptId(long documentReceiptId) {

		this.documentReceiptId = documentReceiptId;
	}

	/**
	 * @return the documentReference
	 */
	public String getDocumentReference() {

		return documentReference;
	}

	/**
	 * @param documentReference
	 *            the documentReference to set
	 */
	public void setDocumentReference(String documentReference) {

		this.documentReference = documentReference;
	}

	/**
	 * @return the numberLocalDocumentReceipt
	 */
	public String getNumberLocalDocumentReceipt() {

		return numberLocalDocumentReceipt;
	}

	/**
	 * @param numberLocalDocumentReceipt
	 *            the numberLocalDocumentReceipt to set
	 */
	public void setNumberLocalDocumentReceipt(String numberLocalDocumentReceipt) {

		this.numberLocalDocumentReceipt = numberLocalDocumentReceipt;
	}

	/**
	 * @return the issuingPlaceName
	 */
	public String getIssuingPlaceName() {

		return issuingPlaceName;
	}

	/**
	 * @param issuingPlaceName
	 *            the issuingPlaceName to set
	 */
	public void setIssuingPlaceName(String issuingPlaceName) {

		this.issuingPlaceName = issuingPlaceName;
	}

	/**
	 * @return the isuuingDate
	 */
	public Date getIsuuingDate() {

		return isuuingDate;
	}

	/**
	 * @param isuuingDate
	 *            the isuuingDate to set
	 */
	public void setIsuuingDate(Date isuuingDate) {

		this.isuuingDate = isuuingDate;
	}

	/**
	 * @return the signer
	 */
	public String getSigner() {

		return signer;
	}

	/**
	 * @param signer
	 *            the signer to set
	 */
	public void setSigner(String signer) {

		this.signer = signer;
	}

	/**
	 * @return the dateArrive
	 */
	public Date getDateArrive() {

		return dateArrive;
	}

	/**
	 * @param dateArrive
	 *            the dateArrive to set
	 */
	public void setDateArrive(Date dateArrive) {

		this.dateArrive = dateArrive;
	}

	/**
	 * @return the processTime
	 */
	public int getProcessTime() {

		return processTime;
	}

	/**
	 * @param processTime
	 *            the processTime to set
	 */
	public void setProcessTime(int processTime) {

		this.processTime = processTime;
	}

	/**
	 * @return the isPublic
	 */
	public String getIsPublic() {

		return isPublic;
	}

	/**
	 * @param isPublic
	 *            the isPublic to set
	 */
	public void setIsPublic(String isPublic) {

		this.isPublic = isPublic;
	}

	/**
	 * @return the levelSendName
	 */
	public String getLevelSendName() {

		return levelSendName;
	}

	/**
	 * @param levelSendName
	 *            the levelSendName to set
	 */
	public void setLevelSendName(String levelSendName) {

		this.levelSendName = levelSendName;
	}

	/**
	 * @return the documentTypeName
	 */
	public String getDocumentTypeName() {

		return documentTypeName;
	}

	/**
	 * @param documentTypeName
	 *            the documentTypeName to set
	 */
	public void setDocumentTypeName(String documentTypeName) {

		this.documentTypeName = documentTypeName;
	}

	/**
	 * @return the confidentialLevelName
	 */
	public String getConfidentialLevelName() {

		return confidentialLevelName;
	}

	/**
	 * @param confidentialLevelName
	 *            the confidentialLevelName to set
	 */
	public void setConfidentialLevelName(String confidentialLevelName) {

		this.confidentialLevelName = confidentialLevelName;
	}

	/**
	 * @return the privilegeLevel
	 */
	public String getPrivilegeLevel() {

		return privilegeLevel;
	}

	/**
	 * @param privilegeLevel
	 *            the privilegeLevel to set
	 */
	public void setPrivilegeLevel(String privilegeLevel) {

		this.privilegeLevel = privilegeLevel;
	}

	/**
	 * @return the briefContent
	 */
	public String getBriefContent() {

		return briefContent;
	}

	/**
	 * @param briefContent
	 *            the briefContent to set
	 */
	public void setBriefContent(String briefContent) {

		this.briefContent = briefContent;
	}

	/**
	 * @return the state
	 */
	public String getState() {

		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {

		this.state = state;
	}

	/**
	 * @return the thoigiannhancvden
	 */
	public String getThoigiannhancvden() {
		return thoigiannhancvden;
	}

	/**
	 * @param thoigiannhancvden
	 *            the thoigiannhancvden to set
	 */
	public void setThoigiannhancvden(String thoigiannhancvden) {
		this.thoigiannhancvden = thoigiannhancvden;
	}

	public String getDonViSaoY() {
		return donViSaoY;
	}

	public void setDonViSaoY(String donViSaoY) {
		this.donViSaoY = donViSaoY;
	}

	public long getDocumentTypeId() {
		return documentTypeId;
	}

	public void setDocumentTypeId(long documentTypeId) {
		this.documentTypeId = documentTypeId;
	}

	public int getDocumentRecordTypeId() {
		return documentRecordTypeId;
	}

	public void setDocumentRecordTypeId(int documentRecordTypeId) {
		this.documentRecordTypeId = documentRecordTypeId;
	}
	
}
