package com.sgs.portlet.pcccdocumentreceiptreport.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.sgs.portlet.pcccdocumentreceiptreport.dto.PCCCDocumentListDTO;

public class DocumentReportSendSearch extends SearchContainer<PCCCDocumentListDTO> {

	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static {
		headerNames.add("sgs_onedoor_no.");
		headerNames.add("receipt.detail");
		headerNames.add("loai-van-ban");
		headerNames.add("receipt.creator");
		headerNames.add("receipt.signer");
		headerNames.add("receipt.receiveplace");
		headerNames.add("document_brief_content");
		headerNames.add("pccc-cvdtn-domat");
		headerNames.add("report-chuyenviendangxuly");
		
		orderableHeaders.put("pccc-cvdtn-domat", "pccc-cvdtn-domat");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "documentreceipt-search-khongtontaidulieu";

	public DocumentReportSendSearch(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(renderRequest, new DocumentReportSendDisplayTerms(renderRequest),
				new DocumentReportSendSearchTerms(renderRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		DocumentReportSendDisplayTerms displayTerms = (DocumentReportSendDisplayTerms)getDisplayTerms();
		
		iteratorURL.setParameter(DocumentReportSendDisplayTerms.DEPARTMENTID, String.valueOf(displayTerms.getDepartmentId()));
		iteratorURL.setParameter(DocumentReportSendDisplayTerms.USERID, String.valueOf(displayTerms.getUserId()));
		iteratorURL.setParameter(DocumentReportSendDisplayTerms.NHOMCONGVAN, String.valueOf(displayTerms.getNhomCongVan()));
		iteratorURL.setParameter(DocumentReportSendDisplayTerms.LOAICONGVAN, String.valueOf(displayTerms.getLoaiCongVan()));
		iteratorURL.setParameter(DocumentReportSendDisplayTerms.DOMAT, String.valueOf(displayTerms.getDoMat()));
		iteratorURL.setParameter(DocumentReportSendDisplayTerms.FROMDATE, String.valueOf(displayTerms.getFromDate()));
		iteratorURL.setParameter(DocumentReportSendDisplayTerms.TODATE, String.valueOf(displayTerms.getToDate()));
		iteratorURL.setParameter(DocumentReportSendDisplayTerms.LOAISOCONGVAN, String.valueOf(displayTerms.getLoaisocongvan()));
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "pccc-cvdtn-domat");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType", "asc");

			String portletName = "SGS_PCCCDOCUMENTRECEIPTREPORT";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "documentsend-order-by-col", orderByCol);
				preferences.setValue(portletName, "documentsend-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "documentsend-order-by-col", "pccc-cvdtn-domat");
				orderByType = preferences.getValue(portletName, "documentsend-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = DocumentDetailUtil.getDocumentDetailOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(DocumentDetailSearch.class);

}
