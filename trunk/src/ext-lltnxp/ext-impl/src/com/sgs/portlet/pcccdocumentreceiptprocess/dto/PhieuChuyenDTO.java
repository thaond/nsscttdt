package com.sgs.portlet.pcccdocumentreceiptprocess.dto;

public class PhieuChuyenDTO {

	private String documentReference = ""; // so van ban goc
	private String numberdocumentreceipt = ""; // so van ban
	private String issuingdate = ""; // ngay ban hanh
	private String hour = ""; // gio den
	private String datearrive = ""; // ngay den
	private String issuingplaceName = ""; // co quan ban hanh
	private String receiver = ""; // nguoi nhan
	private String briefcontent = ""; // trich yeu
	private String processinfomation = ""; // yeu cau xu ly
	private String numdateprocess = ""; // thoi gian xu ly
	private String yKienLanhDaoBan = ""; // y kien lanh dao Ban

	public String getDocumentReference() {
		return documentReference;
	}

	public void setDocumentReference(String documentReference) {
		this.documentReference = documentReference;
	}

	public String getNumberdocumentreceipt() {
		return numberdocumentreceipt;
	}

	public void setNumberdocumentreceipt(String numberdocumentreceipt) {
		this.numberdocumentreceipt = numberdocumentreceipt;
	}

	public String getIssuingdate() {
		return issuingdate;
	}

	public void setIssuingdate(String issuingdate) {
		this.issuingdate = issuingdate;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getDatearrive() {
		return datearrive;
	}

	public void setDatearrive(String datearrive) {
		this.datearrive = datearrive;
	}

	public String getIssuingplaceName() {
		return issuingplaceName;
	}

	public void setIssuingplaceName(String issuingplaceName) {
		this.issuingplaceName = issuingplaceName;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getBriefcontent() {
		return briefcontent;
	}

	public void setBriefcontent(String briefcontent) {
		this.briefcontent = briefcontent;
	}

	public String getProcessinfomation() {
		return processinfomation;
	}

	public void setProcessinfomation(String processinfomation) {
		this.processinfomation = processinfomation;
	}

	public String getNumdateprocess() {
		return numdateprocess;
	}

	public void setNumdateprocess(String numdateprocess) {
		this.numdateprocess = numdateprocess;
	}

	public String getYKienLanhDaoBan() {
		return yKienLanhDaoBan;
	}

	public void setYKienLanhDaoBan(String kienLanhDaoBan) {
		yKienLanhDaoBan = kienLanhDaoBan;
	}

}
