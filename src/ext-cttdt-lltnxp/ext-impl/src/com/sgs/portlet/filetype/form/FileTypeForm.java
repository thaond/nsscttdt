/**
 * 
 */
package com.sgs.portlet.filetype.form;

import org.apache.struts.action.ActionForm;

/**
 * @author lethanhtung
 *
 */
public class FileTypeForm extends ActionForm {
	private String _fileTypeId;
    private String _fileTypeCode;
    private String _fileTypeName;
    private String _fieldId;
    private String _templateId;
    private String _processTime;
    private String _description;
    private String _active;
    private String _currentReceiptNumber;
    private String _receiptTemplate;
    private String _parameter;
    
	/**
	 * 
	 */
	public FileTypeForm() {
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

	/**
	 * @return the _fileTypeId
	 */
	public String get_fileTypeId() {
		return _fileTypeId;
	}

	/**
	 * @param typeId the _fileTypeId to set
	 */
	public void set_fileTypeId(String typeId) {
		_fileTypeId = typeId;
	}

	/**
	 * @return the _fileTypeCode
	 */
	public String get_fileTypeCode() {
		return _fileTypeCode;
	}

	/**
	 * @param typeCode the _fileTypeCode to set
	 */
	public void set_fileTypeCode(String typeCode) {
		_fileTypeCode = typeCode;
	}

	/**
	 * @return the _fileTypeName
	 */
	public String get_fileTypeName() {
		return _fileTypeName;
	}

	/**
	 * @param typeName the _fileTypeName to set
	 */
	public void set_fileTypeName(String typeName) {
		_fileTypeName = typeName;
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
	 * @return the _templateId
	 */
	public String get_templateId() {
		return _templateId;
	}

	/**
	 * @param id the _templateId to set
	 */
	public void set_templateId(String id) {
		_templateId = id;
	}

	/**
	 * @return the _processTime
	 */
	public String get_processTime() {
		return _processTime;
	}

	/**
	 * @param time the _processTime to set
	 */
	public void set_processTime(String time) {
		_processTime = time;
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
	 * @return the _currentReceiptNumber
	 */
	public String get_currentReceiptNumber() {
		return _currentReceiptNumber;
	}

	/**
	 * @param receiptNumber the _currentReceiptNumber to set
	 */
	public void set_currentReceiptNumber(String receiptNumber) {
		_currentReceiptNumber = receiptNumber;
	}

	/**
	 * @return the _receiptTemplate
	 */
	public String get_receiptTemplate() {
		return _receiptTemplate;
	}

	/**
	 * @param template the _receiptTemplate to set
	 */
	public void set_receiptTemplate(String template) {
		_receiptTemplate = template;
	}
    

}
