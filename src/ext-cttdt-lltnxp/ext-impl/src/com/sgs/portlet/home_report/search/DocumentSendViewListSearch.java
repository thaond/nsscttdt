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
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;

/**
 * @author phmphuc dung cho phan hien thi chi tiet danh sach van ban di
 */

public class DocumentSendViewListSearch extends SearchContainer<PmlEdmDocumentSend> {

	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static {
		headerNames.add("sgs_onedoor_no.");
		headerNames.add("pccc-cvdtn-loaicongvan");
		headerNames.add("receipt.detail");
		headerNames.add("receipt.creator");
		headerNames.add("receipt.signer");
		headerNames.add("receipt.receiveplace");
		headerNames.add("receipt.briftcontent");
		
//		orderableHeaders.put("pccc-cvdtn-soCVden", "pccc-cvdtn-soCVden");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "documentreceipt-search-khongtontaidulieu";

	public DocumentSendViewListSearch(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(renderRequest, new DocumentSendViewListDisplayTerms(renderRequest),
				new DocumentSendViewListSearchTerms(renderRequest), DEFAULT_CUR_PARAM,
				10, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		DocumentSendViewListDisplayTerms displayTerms = (DocumentSendViewListDisplayTerms)getDisplayTerms();
		
		iteratorURL.setParameter(DocumentSendViewListDisplayTerms.DEPARTMENTID, String.valueOf(displayTerms.getDepartmentId()));
		iteratorURL.setParameter(DocumentSendViewListDisplayTerms.USERID, String.valueOf(displayTerms.getUserId()));
		iteratorURL.setParameter(DocumentSendViewListDisplayTerms.LOAITHONGKE, String.valueOf(displayTerms.getLoaiThongKe()));
		iteratorURL.setParameter(DocumentSendViewListDisplayTerms.FROMDATE, String.valueOf(displayTerms.getFromDate()));
		iteratorURL.setParameter(DocumentSendViewListDisplayTerms.TODATE, String.valueOf(displayTerms.getToDate()));
		iteratorURL.setParameter(DocumentSendViewListDisplayTerms.LOAISOCONGVAN, String.valueOf(displayTerms.getLoaisocongvan()));
//		
//		try {
//			PortalPreferences preferences =
//				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);
//
//			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
//			String orderByType = ParamUtil.getString(renderRequest, "orderByType");
//
//			String portletName = "SGS_PCCCDOCUMENTRECEIPTREPORT";
//			
//			if (Validator.isNotNull(orderByCol) &&
//				Validator.isNotNull(orderByType)) {
//
//				preferences.setValue(portletName, "documentdetail-order-by-col", orderByCol);
//				preferences.setValue(portletName, "documentdetail-order-by-type", orderByType);
//			}
//			
//			else {
//				orderByCol = preferences.getValue(portletName, "documentdetail-order-by-col", "pccc-cvdtn-soCVden");
//				orderByType = preferences.getValue(portletName, "documentdetail-order-by-type", "desc");
//			}
//
//			OrderByComparator orderByComparator = DocumentDetailUtil.getDocumentDetailOrderByComparator(orderByCol, orderByType);
//
//			setOrderableHeaders(orderableHeaders);
//			
//			setOrderByCol(orderByCol);
//			setOrderByType(orderByType);
//			setOrderByComparator(orderByComparator);
//		}
//		catch (Exception e) {
//			_log.error(e);
//		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(DocumentSendViewListSearch.class);
}
