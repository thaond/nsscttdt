/**
 * 
 */
package com.sgs.portlet.wardsmanagement.form;

import org.apache.struts.action.ActionForm;

/**
 * @author DienNH
 *
 */
public class WardsForm extends ActionForm {

	private String wardsId;
	private String wardsCode;
	private String wardsName;
	private String districtId;
	private String description;
	private int active;
	
	/**
	 * 
	 */
	public WardsForm() {
		// TODO Auto-generated constructor stub
	}

	public String getWardsId() {
		return wardsId;
	}

	public void setWardsId(String wardsId) {
		this.wardsId = wardsId;
	}

	public String getWardsCode() {
		return wardsCode;
	}

	public void setWardsCode(String wardsCode) {
		this.wardsCode = wardsCode;
	}

	public String getWardsName() {
		return wardsName;
	}

	public void setWardsName(String wardsName) {
		this.wardsName = wardsName;
	}

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

}
