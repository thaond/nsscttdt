/**
 * 
 */
package com.sgs.portlet.onedoorsearch.searchresult;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author canhminh
 *
 */
public class PmlOneDoorReceiveFileSearchResultDisplayTerms extends DisplayTerms{
	public static final String MA_HS = "fileId";
	public static final String TEN_HS = "fileName";
	public static final String APPLICANTNAME = "applicantName";
	public static final String ADDRESS = "address";
	public static final String TELEPHONE = "telephone";
	public static final String FILETYPE = "fileType";
	
	public static final String RECEIVEFROMDATE = "receiveFromDate";
	public static final String RECEIVETODATE = "receiveToDate";
	public static final String EXPECTRETURNINGFROMDATE = "expectReturningFromDate";
	public static final String EXPECTRETURNINGTODATE = "expectReturningToDate";
	public static final String COMPLETEFROMDATE = "completeFromDate";
	public static final String COMPLETETODATE = "completeToDate";
	public static final String EXACTRETURNINGFROMDATE = "exactReturningFromDate";
	public static final String EXACTRETURNINGTODATE = "exactReturningToDate";
		
	protected String fileId;
	protected String fileName;
	protected String applicantName;
	protected String address;
	protected String telephone;
	protected String fileTypeId;
	
	protected String receiveFromDate;
	protected String receiveToDate;
	protected String expectReturningFromDate;
	protected String expectReturningToDate;
	protected String completeFromDate;
	protected String completeToDate;
	protected String exactReturningFromDate;
	protected String exactReturningToDate;

	public PmlOneDoorReceiveFileSearchResultDisplayTerms(
			RenderRequest renderRequest) {
		super(renderRequest);
		fileId = ParamUtil.getString(renderRequest, MA_HS);
		fileName = ParamUtil.getString(renderRequest, TEN_HS);
		applicantName = ParamUtil.getString(renderRequest, APPLICANTNAME);
		address = ParamUtil.getString(renderRequest, ADDRESS);
		telephone = ParamUtil.getString(renderRequest, TELEPHONE);
		fileTypeId = ParamUtil.getString(renderRequest, FILETYPE);
		receiveFromDate = ParamUtil.getString(renderRequest, RECEIVEFROMDATE);
		receiveToDate = ParamUtil.getString(renderRequest, RECEIVETODATE);
		expectReturningFromDate = ParamUtil.getString(renderRequest, EXPECTRETURNINGFROMDATE);
		expectReturningToDate = ParamUtil.getString(renderRequest, EXPECTRETURNINGTODATE);
		completeFromDate = ParamUtil.getString(renderRequest, COMPLETEFROMDATE);
		completeToDate = ParamUtil.getString(renderRequest, COMPLETETODATE);
		exactReturningFromDate = ParamUtil.getString(renderRequest, EXACTRETURNINGFROMDATE);
		exactReturningToDate = ParamUtil.getString(renderRequest, EXACTRETURNINGTODATE);
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFileTypeId() {
		return fileTypeId;
	}

	public void setFileTypeId(String fileTypeId) {
		this.fileTypeId = fileTypeId;
	}

	public String getReceiveFromDate() {
		return receiveFromDate;
	}

	public void setReceiveFromDate(String receiveFromDate) {
		this.receiveFromDate = receiveFromDate;
	}

	public String getReceiveToDate() {
		return receiveToDate;
	}

	public void setReceiveToDate(String receiveToDate) {
		this.receiveToDate = receiveToDate;
	}

	public String getExpectReturningFromDate() {
		return expectReturningFromDate;
	}

	public void setExpectReturningFromDate(String expectReturningFromDate) {
		this.expectReturningFromDate = expectReturningFromDate;
	}

	public String getExpectReturningToDate() {
		return expectReturningToDate;
	}

	public void setExpectReturningToDate(String expectReturningToDate) {
		this.expectReturningToDate = expectReturningToDate;
	}

	public String getCompleteFromDate() {
		return completeFromDate;
	}

	public void setCompleteFromDate(String completeFromDate) {
		this.completeFromDate = completeFromDate;
	}

	public String getCompleteToDate() {
		return completeToDate;
	}

	public void setCompleteToDate(String completeToDate) {
		this.completeToDate = completeToDate;
	}

	public String getExactReturningFromDate() {
		return exactReturningFromDate;
	}

	public void setExactReturningFromDate(String exactReturningFromDate) {
		this.exactReturningFromDate = exactReturningFromDate;
	}

	public String getExactReturningToDate() {
		return exactReturningToDate;
	}

	public void setExactReturningToDate(String exactReturningToDate) {
		this.exactReturningToDate = exactReturningToDate;
	}
	
	
}

