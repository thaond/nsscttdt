/**
 * 
 */
package com.sgs.portlet.onedoorsearch.searchresult;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author canhminh
 *
 */
public class PmlOneDoorReceiveFileSearchResultTerms extends PmlOneDoorReceiveFileSearchResultDisplayTerms{

	public PmlOneDoorReceiveFileSearchResultTerms(RenderRequest renderRequest) {
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

}
