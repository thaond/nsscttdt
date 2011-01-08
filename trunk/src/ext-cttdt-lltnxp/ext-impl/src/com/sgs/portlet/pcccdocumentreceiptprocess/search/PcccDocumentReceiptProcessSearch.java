package com.sgs.portlet.pcccdocumentreceiptprocess.search;

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
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;


public class PcccDocumentReceiptProcessSearch extends SearchContainer<PmlEdmDocumentReceipt>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static {
		headerNames.add("sgs_onedoor_no.");
		headerNames.add("pccc-cvdtn-capgoi");
		headerNames.add("pccc-cvdtn-socongvan");
		headerNames.add("pccc-cvdtn-soCVden");
		headerNames.add("pccc-cvdtn-sohieu");
		headerNames.add("document_arriving_date");
		headerNames.add("pccc-cvdtn-noiphathanh");
		headerNames.add("document_brief_content");
		headerNames.add("pccc-TN-noidungxuly");
		headerNames.add("document_status");
		
		orderableHeaders.put("pccc-cvdtn-soCVden", "pccc-cvdtn-soCVden");
		//xuancong close orderableHeaders.put("pccc-cvdtn-sohieu", "pccc-cvdtn-sohieu");

	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "documentreceipt-search-khongtontaidulieu";

	public PcccDocumentReceiptProcessSearch(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(	renderRequest, new PcccDocumentReceiptProcessSearchDisplayTerms(renderRequest),
				new PcccDocumentReceiptProcessSearchTerms(renderRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		
		
		PcccDocumentReceiptProcessSearchDisplayTerms displayTerms = (PcccDocumentReceiptProcessSearchDisplayTerms)getDisplayTerms();
		
		iteratorURL.setParameter(PcccDocumentReceiptProcessSearchDisplayTerms.CAPGUI, String.valueOf(displayTerms.getCapgui()));
		iteratorURL.setParameter(PcccDocumentReceiptProcessSearchDisplayTerms.LOAISOCONGVAN, String.valueOf(displayTerms.getLoaisocongvan()));
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "SGS_PCCCDOCUMENTRECEIPTPROCESS";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "documentworks-order-by-col",	orderByCol);
				preferences.setValue(portletName, "documentworks-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "documentworks-order-by-col", "pccc-cvdtn-soCVden");
				//xuancong close orderByType = preferences.getValue(portletName, "documentworks-order-by-type", "asc");
				orderByType = preferences.getValue(portletName, "documentworks-order-by-type", "desc");
			}

			OrderByComparator orderByComparator = PcccDocumentReceiptProcessUtil.getPcccDocumentReceiptProcessOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PcccDocumentReceiptProcessSearch.class);
}
