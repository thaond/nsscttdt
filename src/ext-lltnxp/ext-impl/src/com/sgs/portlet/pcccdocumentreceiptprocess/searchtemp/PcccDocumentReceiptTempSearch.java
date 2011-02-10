package com.sgs.portlet.pcccdocumentreceiptprocess.searchtemp;

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
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp;
import com.sgs.portlet.pcccdocumentreceiptprocess.util.PcccDocumentReceiptTempSearchUtil;

public class PcccDocumentReceiptTempSearch extends SearchContainer<PmlEdmDocumentReceiptTemp>{
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
		
		orderableHeaders.put("pccc-cvdtn-soCVden", "pccc-cvdtn-soCVden");

	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "documentreceipt-search-khongtontaidulieu";

	public PcccDocumentReceiptTempSearch(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(	renderRequest, new PcccDocumentReceiptTempDisplayTerms(renderRequest),
				new PcccDocumentReceiptTempSearchTerms(renderRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "SGS_PCCCDOCUMENTRECEIPTPROCESS";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "documentnetworks-order-by-col",	orderByCol);
				preferences.setValue(portletName, "documentnetworks-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "documentnetworks-order-by-col", "pccc-cvdtn-soCVden");
				orderByType = preferences.getValue(portletName, "documentnetworks-order-by-type", "desc");
			}

			OrderByComparator orderByComparator = PcccDocumentReceiptTempSearchUtil.getPcccDocumentReceiptTempOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PcccDocumentReceiptTempSearch.class);
}
