package com.sgs.portlet.pcccdocumentreceiptreport.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.sgs.portlet.pcccdocumentreceiptreport.dto.TinhHinhThuLyCongVanDTO;

public class DocumentReportSearch extends SearchContainer<TinhHinhThuLyCongVanDTO> {

	static List<String> headernames = new ArrayList<String>();

	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";

	public DocumentReportSearch(RenderRequest renderRequest,
			PortletURL iteratorURL) {
		super(renderRequest, new DocumentReportDisplayTerms(renderRequest),
				new DocumentReportSearchTerms(renderRequest), DEFAULT_CUR_PARAM, 
				DEFAULT_DELTA, iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
		
		DocumentReportDisplayTerms displayTerms = (DocumentReportDisplayTerms)getDisplayTerms();
	
		iteratorURL.setParameter(DocumentReportDisplayTerms.DEPARTMENTID, String.valueOf(displayTerms.getDepartmentId()));
		iteratorURL.setParameter(DocumentReportDisplayTerms.USERID, String.valueOf(displayTerms.getUserId()));
		iteratorURL.setParameter(DocumentReportDisplayTerms.NHOMCONGVAN, String.valueOf(displayTerms.getNhomCongVan()));
		iteratorURL.setParameter(DocumentReportDisplayTerms.LOAICONGVAN, String.valueOf(displayTerms.getLoaiCongVan()));
		iteratorURL.setParameter(DocumentReportDisplayTerms.FROMDATE, String.valueOf(displayTerms.getFromDate()));
		iteratorURL.setParameter(DocumentReportDisplayTerms.TODATE, String.valueOf(displayTerms.getToDate()));
		iteratorURL.setParameter(DocumentReportDisplayTerms.RADIOTENPHONGBAN, String.valueOf(displayTerms.isRadioTenPhongBan()));
		iteratorURL.setParameter(DocumentReportDisplayTerms.RADIOTENCHUYENVIEN, String.valueOf(displayTerms.isRadioTenChuyenVien()));
		iteratorURL.setParameter(DocumentReportDisplayTerms.DOMAT, displayTerms.doMat);
	}
}
