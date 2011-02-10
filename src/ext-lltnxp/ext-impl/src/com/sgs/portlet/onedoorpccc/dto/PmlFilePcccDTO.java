/**
 * 
 */
package com.sgs.portlet.onedoorpccc.dto;

import java.util.Date;

import com.sgs.portlet.onedoor.dto.PmlFileDTO;


/**
 * @author kienbqc
 *
 */
public class PmlFilePcccDTO extends PmlFileDTO {
	
	private String fileName;
	private String applicantRepresentation;
	private String applicantTelephone;
	private String receiverRepresentation;
	private int levelSendId;
	private String issuingPlaceId;
	private String issuingPlaceOrtherName ;
	private Date asignDate;
	private int trate;
	private int disPraise;
	private String contentHSKT;
	private String numberDoc;
	
	private String receiverTelephone;
	private String projectname;
	private String applicantCategory;
	private String addressBuilder;
	private String investor;
	private String designCop;
	private int fileNumber;
	private Date inputDataDate;
	private String noteInformationManagement;
	private String conclusion;
	private String lastTestProcessInfo;
	private Date sendDate;
	private Date receiveDate;
	private Date expireDate;
	private Date returnDate;
	private String applicantTime;
	
	// report
	private String stt;
	private String expectedReturingDateReport;
	private String sendDateReport;
	private String receiveDateReport;
	private String expireDateReport;
	private String inputDataDateReport;
	
	public String getStt() {
		return stt;
	}


	public void setStt(String stt) {
		this.stt = stt;
	}

	public String getExpectedReturingDateReport() {
		return expectedReturingDateReport;
	}


	public void setExpectedReturingDateReport(String expectedReturingDateReport) {
		this.expectedReturingDateReport = expectedReturingDateReport;
	}


	public String getSendDateReport() {
		return sendDateReport;
	}


	public void setSendDateReport(String sendDateReport) {
		this.sendDateReport = sendDateReport;
	}


	public String getReceiveDateReport() {
		return receiveDateReport;
	}


	public void setReceiveDateReport(String receiveDateReport) {
		this.receiveDateReport = receiveDateReport;
	}


	public String getExpireDateReport() {
		return expireDateReport;
	}


	public void setExpireDateReport(String expireDateReport) {
		this.expireDateReport = expireDateReport;
	}

	public String getInputDataDateReport() {
		return inputDataDateReport;
	}


	public void setInputDataDateReport(String inputDataDateReport) {
		this.inputDataDateReport = inputDataDateReport;
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
	 * @return the receiveDate
	 */
	public Date getReceiveDate() {
	
		return receiveDate;
	}

	
	/**
	 * @param receiveDate the receiveDate to set
	 */
	public void setReceiveDate(Date receiveDate) {
	
		this.receiveDate = receiveDate;
	}

	
	/**
	 * @return the expireDate
	 */
	public Date getExpireDate() {
	
		return expireDate;
	}

	
	/**
	 * @param expireDate the expireDate to set
	 */
	public void setExpireDate(Date expireDate) {
	
		this.expireDate = expireDate;
	}

	
	/**
	 * @return the returnDate
	 */
	public Date getReturnDate() {
	
		return returnDate;
	}

	
	/**
	 * @param returnDate the returnDate to set
	 */
	public void setReturnDate(Date returnDate) {
	
		this.returnDate = returnDate;
	}

	/**
	 * @return the lastTestProcessInfo
	 */
	public String getLastTestProcessInfo() {
		return lastTestProcessInfo;
	}

	/**
	 * @param lastTestProcessInfo the lastTestProcessInfo to set
	 */
	public void setLastTestProcessInfo(String lastTestProcessInfo) {
		this.lastTestProcessInfo = lastTestProcessInfo;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
	
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
	
		this.fileName = fileName;
	}
	
	/**
	 * @return the applicantRepresentation
	 */
	public String getApplicantRepresentation() {
	
		return applicantRepresentation;
	}
	
	/**
	 * @param applicantRepresentation the applicantRepresentation to set
	 */
	public void setApplicantRepresentation(String applicantRepresentation) {
	
		this.applicantRepresentation = applicantRepresentation;
	}
	
	/**
	 * @return the applicantTelephone
	 */
	public String getApplicantTelephone() {
	
		return applicantTelephone;
	}
	
	/**
	 * @param applicantTelephone the applicantTelephone to set
	 */
	public void setApplicantTelephone(String applicantTelephone) {
	
		this.applicantTelephone = applicantTelephone;
	}
	
	/**
	 * @return the receiverRepresentation
	 */
	public String getReceiverRepresentation() {
	
		return receiverRepresentation;
	}
	public void  setLevelSendId(int levelSendId){
		this.levelSendId = levelSendId;
	}
	public int getLevelSendId(){
		return levelSendId;
	}
	
	public void SetIssuingPlaceId(String issuingPlaceId){
		this.issuingPlaceId = issuingPlaceId;
	}
	public String getIssuingPlaceId(){
		return issuingPlaceId;
	}
	
	public void setIssuingPlaceOrtherName (String issuingPlaceOrtherName){
		this.issuingPlaceOrtherName = issuingPlaceOrtherName;
	}
	public String getIssuingPlaceOrtherName (){
		return issuingPlaceOrtherName;
	}
	
	public void setAsignDate (Date asignDate){
		this.asignDate = asignDate;
	}
	public Date getAsignDate (){
		return asignDate;
	}
	public void setTrate (int trate){
		this.trate = trate;
	}
	public int getTrate (){
		return trate;
	}	
	public void setDisPraise (int disPraise){
		this.disPraise = disPraise;
	}
	public int getDisPraise (){
		return disPraise;
	}
	public void setContentHSKT (String contentHSKT){
		this.contentHSKT = contentHSKT;
	}
	public String getContentHSKT (){
		return contentHSKT;
	}		
	public void setNumberDoc (String numberDoc){
		this.numberDoc = numberDoc;
	}
	public String getNumberDoc (){
		return numberDoc;
	}		
	/**
	 * @param receiverRepresentation the receiverRepresentation to set
	 */
	public void setReceiverRepresentation(String receiverRepresentation) {
	
		this.receiverRepresentation = receiverRepresentation;
	}
	
	/**
	 * @return the receiverTelephone
	 */
	public String getReceiverTelephone() {
	
		return receiverTelephone;
	}
	
	/**
	 * @param receiverTelephone the receiverTelephone to set
	 */
	public void setReceiverTelephone(String receiverTelephone) {
	
		this.receiverTelephone = receiverTelephone;
	}
	
	/**
	 * @return the projectname
	 */
	public String getProjectname() {
	
		return projectname;
	}
	
	/**
	 * @param projectname the projectname to set
	 */
	public void setProjectname(String projectname) {
	
		this.projectname = projectname;
	}
	
	/**
	 * @return the applicantCategory
	 */
	public String getApplicantCategory() {
	
		return applicantCategory;
	}
	
	/**
	 * @param applicantCategory the applicantCategory to set
	 */
	public void setApplicantCategory(String applicantCategory) {
	
		this.applicantCategory = applicantCategory;
	}
	
	/**
	 * @return the addressBuilder
	 */
	public String getAddressBuilder() {
	
		return addressBuilder;
	}
	
	/**
	 * @param addressBuilder the addressBuilder to set
	 */
	public void setAddressBuilder(String addressBuilder) {
	
		this.addressBuilder = addressBuilder;
	}
	
	/**
	 * @return the investor
	 */
	public String getInvestor() {
	
		return investor;
	}
	
	/**
	 * @param investor the investor to set
	 */
	public void setInvestor(String investor) {
	
		this.investor = investor;
	}
	
	/**
	 * @return the designCop
	 */
	public String getDesignCop() {
	
		return designCop;
	}
	
	/**
	 * @param designCop the designCop to set
	 */
	public void setDesignCop(String designCop) {
	
		this.designCop = designCop;
	}
	
	/**
	 * @return the fileNumber
	 */
	public int getFileNumber() {
	
		return fileNumber;
	}
	
	/**
	 * @param fileNumber the fileNumber to set
	 */
	public void setFileNumber(int fileNumber) {
	
		this.fileNumber = fileNumber;
	}
	
	/**
	 * @return the inputDataDate
	 */
	public Date getInputDataDate() {
	
		return inputDataDate;
	}
	
	/**
	 * @param inputDataDate the inputDataDate to set
	 */
	public void setInputDataDate(Date inputDataDate) {
	
		this.inputDataDate = inputDataDate;
	}
	
	/**
	 * @return the noteInformationManagement
	 */
	public String getNoteInformationManagement() {
	
		return noteInformationManagement;
	}
	
	/**
	 * @param noteInformationManagement the noteInformationManagement to set
	 */
	public void setNoteInformationManagement(String noteInformationManagement) {
	
		this.noteInformationManagement = noteInformationManagement;
	}
	
	/**
	 * @return the conclusion
	 */
	public String getConclusion() {
	
		return conclusion;
	}
	
	/**
	 * @param conclusion the conclusion to set
	 */
	public void setConclusion(String conclusion) {
	
		this.conclusion = conclusion;
	}


	public String getApplicantTime() {
		return applicantTime;
	}


	public void setApplicantTime(String applicantTime) {
		this.applicantTime = applicantTime;
	}
	
	
}
