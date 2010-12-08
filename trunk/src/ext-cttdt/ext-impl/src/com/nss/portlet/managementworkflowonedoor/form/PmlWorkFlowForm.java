/**
 * 
 */
package com.nss.portlet.managementworkflowonedoor.form;

import java.io.File;
import java.util.Date;

import org.apache.struts.action.ActionForm;


/**
 * @author lethanhtung
 *
 */
public class PmlWorkFlowForm extends ActionForm {
	private long _workflowId;
    private String _departmentsId;
    private String _fileTypeId;
    private String _workflow;
    private int _version_;
    private Date _startDate;
    private Date _endDate;
    private File file_upload;
    
	/**
	 * 
	 */
	public PmlWorkFlowForm() {
	}

	
	/**
	 * @return the _workflowId
	 */
	public long get_workflowId() {
	
		return _workflowId;
	}

	
	/**
	 * @param id the _workflowId to set
	 */
	public void set_workflowId(long id) {
	
		_workflowId = id;
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
	 * @return the _workflow
	 */
	public String get_workflow() {
	
		return _workflow;
	}

	
	/**
	 * @param _workflow the _workflow to set
	 */
	public void set_workflow(String _workflow) {
	
		this._workflow = _workflow;
	}

	
	/**
	 * @return the _version_
	 */
	public int get_version_() {
	
		return _version_;
	}

	
	/**
	 * @param _version_ the _version_ to set
	 */
	public void set_version_(int _version_) {
	
		this._version_ = _version_;
	}

	
	/**
	 * @return the _startDate
	 */
	public Date get_startDate() {
	
		return _startDate;
	}

	
	/**
	 * @param date the _startDate to set
	 */
	public void set_startDate(Date date) {
	
		_startDate = date;
	}

	
	/**
	 * @return the _endDate
	 */
	public Date get_endDate() {
	
		return _endDate;
	}

	
	/**
	 * @param date the _endDate to set
	 */
	public void set_endDate(Date date) {
	
		_endDate = date;
	}
    

}
