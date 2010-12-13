package com.nss.portlet.onedoor.ajax;

public class ProcessTransition {
	private int transition;
	private String nameTransition;
	private int processTime;
	private String ghiChu;
	
	public ProcessTransition() {
	}

	public ProcessTransition(int transition, String nameTransition, int processTime,
			String ghiChu) {
		this.transition = transition;
		this.nameTransition = nameTransition;
		this.processTime = processTime;
		this.ghiChu = ghiChu;
	}

	public String getNameTransition() {
		return nameTransition;
	}

	public void setNameTransition(String nameTransition) {
		this.nameTransition = nameTransition;
	}

	public int getTransition() {
		return transition;
	}

	public void setTransition(int transition) {
		this.transition = transition;
	}

	public int getProcessTime() {
		return processTime;
	}

	public void setProcessTime(int processTime) {
		this.processTime = processTime;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
}
