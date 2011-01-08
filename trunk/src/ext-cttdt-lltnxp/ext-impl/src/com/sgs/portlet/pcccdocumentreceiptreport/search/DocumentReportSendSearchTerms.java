package com.sgs.portlet.pcccdocumentreceiptreport.search;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author phmphuc dung cho phan hien thi chi tiet danh sach cong van
 */

public class DocumentReportSendSearchTerms extends DocumentReportSendDisplayTerms {

	public DocumentReportSendSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		departmentId = ParamUtil.getString(renderRequest, DEPARTMENTID);
		userId = ParamUtil.getLong(renderRequest, USERID);
		nhomCongVan = ParamUtil.getInteger(renderRequest, NHOMCONGVAN);
		loaiCongVan = ParamUtil.getString(renderRequest, LOAICONGVAN);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		fromDate = ParamUtil.getString(renderRequest, FROMDATE, dateFormat
				.format(new Date()));
		toDate = ParamUtil.getString(renderRequest, TODATE, dateFormat
				.format(new Date()));
		
		doMat = ParamUtil.getString(renderRequest, DOMAT);
		
		loaisocongvan = DAOParamUtil.getInteger(renderRequest, LOAISOCONGVAN);
	}
}
