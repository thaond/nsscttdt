/**
 * 
 */
package com.sgs.portlet.citymanagement.form;

import org.apache.struts.action.ActionForm;

/**
 * @author DienNH
 *
 */
public class CityForm extends ActionForm {

	private String cityID;
	private String cityCode;
	private String cityName;
	private String description;
	private int active;
	
	/**
	 * 
	 */
	public CityForm() {
		// TODO Auto-generated constructor stub
	}

	public String getCityID() {
		return cityID;
	}

	public void setCityID(String cityID) {
		this.cityID = cityID;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
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
