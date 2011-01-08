/**
 * 
 */
package com.sgs.portlet.districtmanagement.form;

import org.apache.struts.action.ActionForm;

/**
 * @author DienNH
 *
 */
public class DistrictForm extends ActionForm {

	private String districtId;
	private String districtCode;
	private String districtName;
	private String cityID;
	private String description;
	private int active;
	
	/**
	 * 
	 */
	public DistrictForm() {
		// TODO Auto-generated constructor stub
	}

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getCityID() {
		return cityID;
	}

	public void setCityID(String cityID) {
		this.cityID = cityID;
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
