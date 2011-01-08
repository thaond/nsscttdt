/**
 * 
 */
package com.sgs.portlet.documenttype.search;

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
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.documenttype.util.PmlEdmDocumentTypeSearchUtil;

/**
 * @author canhminh
 *
 */
public class PmlEdmDocumentTypeSearch extends SearchContainer< PmlEdmDocumentType>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("sgs_onedoor_no.");
		headerNames.add("recordtype.code");
		headerNames.add("ten-loai-cong-van");
		headerNames.add("ten-loai-so-cong-van");
		headerNames.add("su-dung-cho");
		headerNames.add("co-gan-phan-mo-rong");
		headerNames.add("");
		
		orderableHeaders.put("ten-loai-cong-van", "ten-loai-cong-van");
		orderableHeaders.put("ten-loai-so-cong-van", "ten-loai-so-cong-van");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public PmlEdmDocumentTypeSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new PmlEdmDocumentTypeDisplayTerms(renderRequest), new PmlEdmDocumentTypeSearchTerms(renderRequest),
					DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			PmlEdmDocumentTypeDisplayTerms displayTerms = (PmlEdmDocumentTypeDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(PmlEdmDocumentTypeDisplayTerms.PMLEDMDOCUMENTTYPE_NAME, displayTerms.getPmlEdmDocumentTypeName());
			iteratorURL.setParameter(PmlEdmDocumentTypeDisplayTerms.PMLEDMDOCUMENTTYPE_DOCUMENTRECORDTYPENAME, displayTerms.getPmlEdmDocumentRecordTypeName());
			
			try {
				PortalPreferences preferences =
					PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "SGS_DOCUMENTTYPE";
				
				if (Validator.isNotNull(orderByCol) &&
					Validator.isNotNull(orderByType)) {

					preferences.setValue(portletName, "pmledmdocumenttype-order-by-col", orderByCol);
					preferences.setValue(portletName, "pmledmdocumenttype-order-by-type", orderByType);
				}
				
				else {
					orderByCol = preferences.getValue(portletName, "pmledmdocumenttype-order-by-col", "ten-loai-cong-van");
					orderByType = preferences.getValue(portletName, "pmledmdocumenttype-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = PmlEdmDocumentTypeSearchUtil.getPmlEdmDocumentTypeOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(PmlEdmDocumentTypeSearch.class);
}
