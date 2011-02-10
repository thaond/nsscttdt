package com.sgs.portlet.documentrecordtype.search;

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
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.documentrecordtype.util.PmlEdmDocumentRecordTypeSearchUtil;

public class PmlEdmDocumentRecordTypeSearch extends SearchContainer<PmlEdmDocumentRecordType>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("pccc-TN-stt");
		headerNames.add("recordtype.code");
		headerNames.add("ten-loai-so-cong-van");
		headerNames.add("");
		
		orderableHeaders.put("recordtype.code", "recordtype.code");
		orderableHeaders.put("ten-loai-so-cong-van", "ten-loai-so-cong-van");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public PmlEdmDocumentRecordTypeSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new PmlEdmDocumentRecordTypeDisplayTerms(renderRequest), new PmlEdmDocumentRecordTypeSearchTerms(renderRequest),
					DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			PmlEdmDocumentRecordTypeDisplayTerms displayTerms = (PmlEdmDocumentRecordTypeDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(PmlEdmDocumentRecordTypeDisplayTerms.PMLEDMDOCUMENTRECORDTYPE_CODE, displayTerms.getPmlEdmDocumentRecordTypeCode());
			iteratorURL.setParameter(PmlEdmDocumentRecordTypeDisplayTerms.PMLEDMDOCUMENTRECORDTYPE_NAME, displayTerms.getPmlEdmDocumentRecordTypeName() );
			
			try {
				PortalPreferences preferences =
					PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "SGS_DOCUMENTRECORDTYPE";
				
				if (Validator.isNotNull(orderByCol) &&
					Validator.isNotNull(orderByType)) {

					preferences.setValue(portletName, "pmledmdocumentrecordtype-order-by-col", orderByCol);
					preferences.setValue(portletName, "pmledmdocumentrecordtype-order-by-type", orderByType);
				}
				
				else {
					orderByCol = preferences.getValue(portletName, "pmledmdocumentrecordtype-order-by-col", "ten-loai-so-cong-van");
					orderByType = preferences.getValue(portletName, "pmledmdocumentrecordtype-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = PmlEdmDocumentRecordTypeSearchUtil.getPmlEdmDocumentRecordTypeOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(PmlEdmDocumentRecordTypeSearch.class);
}
