/**
 * 
 */
package com.sgs.portlet.onedoorpccc.dto;


/**
 * @author kienbqc
 *
 */
public class StepWorkFlowDTO {
	private String stepName;
	private int timeProcess;
	private String note;
	
	/**
	 * @return the stepName
	 */
	public String getStepName() {
	
		return stepName;
	}
	
	/**
	 * @param stepName the stepName to set
	 */
	public void setStepName(String stepName) {
	
		this.stepName = stepName;
	}
	
	/**
	 * @return the timeProcess
	 */
	public int getTimeProcess() {
	
		return timeProcess;
	}
	
	/**
	 * @param timeProcess the timeProcess to set
	 */
	public void setTimeProcess(int timeProcess) {
	
		this.timeProcess = timeProcess;
	}
	
	/**
	 * @return the note
	 */
	public String getNote() {
	
		return note;
	}
	
	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
	
		this.note = note;
	}
	
}
