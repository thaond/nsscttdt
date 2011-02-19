/**
 * 
 */
package com.sgs.portlet.pcccdocumentsendprocess.search;

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
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;

/**
 * @author minh.nv
 *
 */
public class PcccDocumentSendProcessSearch extends SearchContainer<PmlEdmDocumentSend>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static {
		headerNames.add("sgs_onedoor_no.");
		headerNames.add("receipt.docrectype");
		headerNames.add("receipt.detail");
		headerNames.add("receipt.creator");
		headerNames.add("receipt.signer");
		headerNames.add("receipt.receiveplace");
		headerNames.add("receipt.briftcontent");
		headerNames.add("pccc-TN-noidungxuly");
		headerNames.add("document_status");
		
		
		orderableHeaders.put("receipt.creator", "receipt.creator");
//		orderableHeaders.put("receipt.signer", "receipt.signer");
//		orderableHeaders.put("receipt.receiveplace", "receipt.receiveplace");
	}

	
	public static final String EMPTY_RESULTS_MESSAGE = "documentsend-search-khongtontaidulieu";

	public PcccDocumentSendProcessSearch(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(	renderRequest, new PcccDocumentSendProcessSearchDisplayTerms(renderRequest),
				new PcccDocumentSendProcessSearchTerms(renderRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		
		
		PcccDocumentSendProcessSearchDisplayTerms displayTerms = (PcccDocumentSendProcessSearchDisplayTerms)getDisplayTerms();
		
		iteratorURL.setParameter(PcccDocumentSendProcessSearchDisplayTerms.LOAISOCONGVAN, String.valueOf(displayTerms.getLoaiSoCongVan()));
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "SGS_PCCCDOCUMENTSENDPROCESS";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "documentworks-order-by-col",	orderByCol);
				preferences.setValue(portletName, "documentworks-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "documentworks-order-by-col", "receipt.creator");
				orderByType = preferences.getValue(portletName, "documentworks-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = PcccDocumentSendProcessUtil.getPcccDocumentSendProcessOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PcccDocumentSendProcessSearch.class);
}
