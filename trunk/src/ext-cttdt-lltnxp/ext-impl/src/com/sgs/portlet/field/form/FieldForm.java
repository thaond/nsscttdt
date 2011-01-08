/**
 * 
 */
package com.sgs.portlet.field.form;

import org.apache.struts.action.ActionForm;

/**
 * @author lethanhtung
 *
 */
public class FieldForm extends ActionForm {
	private String _fieldId;
    private String _fieldCode;
    private String _fieldName;
    private String _description;
    private String _active;
    private String _parameter;
    private String _departmentsId;
    
	/**
	 * 
	 */
	public FieldForm() {
	}

	
	/**
	 * @return the _fieldId
	 */
	public String get_fieldId() {
		return _fieldId;
	}

	/**
	 * @param id the _fieldId to set
	 */
	public void set_fieldId(String id) {
		_fieldId = id;
	}
	

	/**
	 * @return the _departmentsId
	 */
	public String get_departmentsId() {
	
		return _departmentsId;
	}

	
	/**
	 * @param id the _departmentsId to set
	 */
	public void set_departmentsId(String id) {
	
		_departmentsId = id;
	}


	/**
	 * @return the _fieldCode
	 */
	public String get_fieldCode() {
		return _fieldCode;
	}

	/**
	 * @param code the _fieldCode to set
	 */
	public void set_fieldCode(String code) {
		_fieldCode = code;
	}

	/**
	 * @return the _fieldName_parameter
	 */
	public String get_fieldName() {
		return _fieldName;
	}

	/**
	 * @param name the _fieldName to set
	 */
	public void set_fieldName(String name) {
		_fieldName = name;
	}

	/**
	 * @return the _description
	 */
	public String get_description() {
		return _description;
	}

	/**
	 * @param _description the _description to set
	 */
	public void set_description(String _description) {
		this._description = _description;
	}

	/**
	 * @return the _active
	 */
	public String get_active() {
		return _active;
	}

	/**
	 * @param _active the _active to set
	 */
	public void set_active(String _active) {
		this._active = _active;
	}

	/**
	 * @return the _parameter
	 */
	public String get_parameter() {
		return _parameter;
	}

	/**
	 * @param _parameter the _parameter to set
	 */
	public void set_parameter(String _parameter) {
		this._parameter = _parameter;
	}
    

}
