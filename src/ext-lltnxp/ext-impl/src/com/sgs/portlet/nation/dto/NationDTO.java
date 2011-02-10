/**
 * 
 */
package com.sgs.portlet.nation.dto;


/**
 * @author kienbqc
 *
 */
public class NationDTO {
	private String nationId;
	private String nationCode;
	private String nationName;
	private String countryName;
	private String description;
	private String active;
	
	public String getNationId() {
	
		return nationId;
	}
	
	public void setNationId(String nationId) {
	
		this.nationId = nationId;
	}
	
	public String getNationCode() {
	
		return nationCode;
	}
	
	public void setNationCode(String nationCode) {
	
		this.nationCode = nationCode;
	}
	
	public String getNationName() {
	
		return nationName;
	}
	
	public void setNationName(String nationName) {
	
		this.nationName = nationName;
	}
	
	public String getCountryName() {
	
		return countryName;
	}
	
	public void setCountryName(String countryName) {
	
		this.countryName = countryName;
	}
	
	public String getDescription() {
	
		return description;
	}
	
	public void setDescription(String description) {
	
		this.description = description;
	}
	
	public String getActive() {
	
		return active;
	}
	
	public void setActive(String active) {
	
		this.active = active;
	}
	
}
