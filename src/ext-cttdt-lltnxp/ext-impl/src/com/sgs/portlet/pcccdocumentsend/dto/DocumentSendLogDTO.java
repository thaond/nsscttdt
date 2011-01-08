package com.sgs.portlet.pcccdocumentsend.dto;

import java.util.Date;

public class DocumentSendLogDTO {
	private String processor;
	private Date dateProcess;
	private String processInformation;
	private String receiver;
	private Date receiverDate;
	private Date expireDate;
	private int numberDateProcess;
	
	/**
	 * @return the processor
	 */
	public String getProcessor() {
	
		return processor;
	}
	
	/**
	 * @param processor the processor to set
	 */
	public void setProcessor(String processor) {
	
		this.processor = processor;
	}
	
	/**
	 * @return the dateProcess
	 */
	public Date getDateProcess() {
	
		return dateProcess;
	}
	
	/**
	 * @param dateProcess the dateProcess to set
	 */
	public void setDateProcess(Date dateProcess) {
	
		this.dateProcess = dateProcess;
	}
	
	/**
	 * @return the processInformation
	 */
	public String getProcessInformation() {
	
		return processInformation;
	}
	
	/**
	 * @param processInformation the processInformation to set
	 */
	public void setProcessInformation(String processInformation) {
	
		this.processInformation = processInformation;
	}
	
	/**
	 * @return the receiver
	 */
	public String getReceiver() {
	
		return receiver;
	}
	
	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(String receiver) {
	
		this.receiver = receiver;
	}
	
	/**
	 * @return the receiverDate
	 */
	public Date getReceiverDate() {
	
		return receiverDate;
	}
	
	/**
	 * @param receiverDate the receiverDate to set
	 */
	public void setReceiverDate(Date receiverDate) {
	
		this.receiverDate = receiverDate;
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
	 * @return the numberDateProcess
	 */
	public int getNumberDateProcess() {
	
		return numberDateProcess;
	}
	
	/**
	 * @param numberDateProcess the numberDateProcess to set
	 */
	public void setNumberDateProcess(int numberDateProcess) {
	
		this.numberDateProcess = numberDateProcess;
	}
}
