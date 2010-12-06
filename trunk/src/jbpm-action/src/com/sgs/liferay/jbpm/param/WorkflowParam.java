/**
 * 
 */
package com.sgs.liferay.jbpm.param;

/**
 * @author hieuvh
 *
 */
public class WorkflowParam {
	public static final String PERSISTENCE = "persistence";
	public static final String TRANSIENT = "transient";
	
	// default transaction type of parameter is transient
	private String transactionType = TRANSIENT;
	private String name;
	private String value;
	
	public WorkflowParam() {
	}
	
	public WorkflowParam(String transactionType, String name, String value) {
		this.transactionType = transactionType;
		this.name = name;
		this.value = value;
	}

	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
