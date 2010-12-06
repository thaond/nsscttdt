/**
 * 
 */
package com.sgs.liferay.jbpm.component;

/**
 * @author hieuvh
 * 
 */
public class TaskAction {
	public static final String NONE_TRANSITION = "none";
	public static final String NONE_FORM = "none";

	private long taskInstanceId;
	private String taskActionName;
	
	private String form;
	private String transition;

	/**
	 * @return the taskInstanceId
	 */
	public long getTaskInstanceId() {
		return taskInstanceId;
	}

	/**
	 * @param taskInstanceId
	 *            the taskInstanceId to set
	 */
	public void setTaskInstanceId(long taskInstanceId) {
		this.taskInstanceId = taskInstanceId;
	}

	/**
	 * @return the taskActionName
	 */
	public String getTaskActionName() {
		return taskActionName;
	}

	/**
	 * @param taskActionName
	 *            the taskActionName to set
	 */
	public void setTaskActionName(String taskActionName) {
		this.taskActionName = taskActionName;
	}

	/**
	 * @return the form
	 */
	public String getForm() {
		return form;
	}

	/**
	 * @param form
	 *            the form to set
	 */
	public void setForm(String form) {
		this.form = form;
	}

	/**
	 * @return the transition
	 */
	public String getTransition() {
		return transition;
	}

	/**
	 * @param transition
	 *            the transition to set
	 */
	public void setTransition(String transition) {
		this.transition = transition;
	}
}
