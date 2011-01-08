package com.sgs.portlet.home_report.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;

/**
 * @author phmphuc dung cho phan hien thi chi tiet danh sach van ban den
 */

public class DocumentReceiptViewListSearch extends SearchContainer<PmlEdmDocumentReceipt> {

	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static {
		headerNames.add("sgs_onedoor_no.");
		headerNames.add("pccc-cvdtn-capgoi");
		headerNames.add("pccc-cvdtn-loaicongvan");
		headerNames.add("pccc-cvdtn-soCVden");
		headerNames.add("pccc-cvdtn-sohieu");
		headerNames.add("document_arriving_date");
		headerNames.add("pccc-cvdtn-noiphathanh");
		headerNames.add("document_brief_content");
		headerNames.add("report-cachthucxuly");
		headerNames.add("report-chuyenviendangxuly");
		
//		orderableHeaders.put("report-chuyenviendangxuly", "report-chuyenviendangxuly");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "documentreceipt-search-khongtontaidulieu";

	public DocumentReceiptViewListSearch(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(renderRequest, new DocumentReceiptViewListDisplayTerms(renderRequest),
				new DocumentReceiptViewListSearchTerms(renderRequest), DEFAULT_CUR_PARAM,
				10, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		DocumentReceiptViewListDisplayTerms displayTerms = (DocumentReceiptViewListDisplayTerms)getDisplayTerms();
		
		iteratorURL.setParameter(DocumentReceiptViewListDisplayTerms.DEPARTMENTID, String.valueOf(displayTerms.getDepartmentId()));
		iteratorURL.setParameter(DocumentReceiptViewListDisplayTerms.USERID, String.valueOf(displayTerms.getUserId()));
		iteratorURL.setParameter(DocumentReceiptViewListDisplayTerms.LOAITHONGKE, String.valueOf(displayTerms.getLoaiThongKe()));
		iteratorURL.setParameter(DocumentReceiptViewListDisplayTerms.FROMDATE, String.valueOf(displayTerms.getFromDate()));
		iteratorURL.setParameter(DocumentReceiptViewListDisplayTerms.TODATE, String.valueOf(displayTerms.getToDate()));
		iteratorURL.setParameter(DocumentReceiptViewListDisplayTerms.CAPGUI, String.valueOf(displayTerms.getCapgui()));
		iteratorURL.setParameter(DocumentReceiptViewListDisplayTerms.LOAISOCONGVAN, String.valueOf(displayTerms.getLoaisocongvan()));
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "SGS_HOME_REPORT";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "documentdetail-order-by-col", orderByCol);
				preferences.setValue(portletName, "documentdetail-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "documentdetail-order-by-col", "report-chuyenviendangxuly");
				orderByType = preferences.getValue(portletName, "documentdetail-order-by-type", "asc");
			}

//			OrderByComparator orderByComparator = DocumentDetailUtil.getDocumentDetailOrderByComparator(orderByCol, orderByType);
//
//			setOrderableHeaders(orderableHeaders);
//			
//			setOrderByCol(orderByCol);
//			setOrderByType(orderByType);
//			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(DocumentReceiptViewListSearch.class);

}
