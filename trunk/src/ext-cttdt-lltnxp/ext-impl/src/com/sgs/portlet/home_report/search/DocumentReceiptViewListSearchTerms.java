package com.sgs.portlet.home_report.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author phmphuc dung cho phan hien thi chi tiet danh sach van ban den
 */

public class DocumentReceiptViewListSearchTerms extends DocumentReceiptViewListDisplayTerms {

	public DocumentReceiptViewListSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		departmentId = ParamUtil.getString(renderRequest, DEPARTMENTID);
		userId = ParamUtil.getLong(renderRequest, USERID);
		loaiThongKe = ParamUtil.getString(renderRequest, LOAITHONGKE);
		fromDate = ParamUtil.getString(renderRequest, FROMDATE);
		toDate = ParamUtil.getString(renderRequest, TODATE);
		
		capgui =  DAOParamUtil.getInteger(renderRequest, CAPGUI);
		loaisocongvan = DAOParamUtil.getInteger(renderRequest, LOAISOCONGVAN);
	}
}
