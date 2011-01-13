package com.sgs.portlet.document_manager.search;

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
import com.sgs.portlet.document_manager.model.DocumentManager;
import com.sgs.portlet.document_manager.util.DocumentManagerSearchUtil;

public class DocumentManagerSearch extends SearchContainer<DocumentManager>{
	
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static{
		headerNames.add("stt");
		headerNames.add("document-manager-code");
		headerNames.add("document-manager-date-create");
		headerNames.add("document-manager-description");
		headerNames.add("document-manager-title");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("document-manager-code", "documentManagerCode");
		orderableHeaders.put("document-manager-description", "documentManagerDescription");
		orderableHeaders.put("document-manager-title", "documentManagerTitle");
	}

	public static final String EMPTY_RESULTS_MESSAGE = "no-document-manager-were-found";
	
	public DocumentManagerSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new DocumentManagerDisplayTerms(renderRequest), new DocumentManagerSearchTerms(renderRequest),
						DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			DocumentManagerDisplayTerms displayTerms = (DocumentManagerDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(DocumentManagerDisplayTerms.DOCUMENTMANAGERCODE, displayTerms.getDocumentManagerCode());
			iteratorURL.setParameter(DocumentManagerDisplayTerms.DOCUMENTMANAGERDESCRIPTION, displayTerms.getDocumentManagerDescription());
			iteratorURL.setParameter(DocumentManagerDisplayTerms.DOCUMENTMANAGERTITLE, displayTerms.getDocumentManagerTitle());
			
			try {
				PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "SGS_DOCUMENT_MANAGER";
				
				if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
					preferences.setValue(portletName, "document-manager-order-by-col", orderByCol);
					preferences.setValue(portletName, "document-manager-order-by-type", orderByType);
				} else {
					orderByCol = preferences.getValue(portletName, "document-manager-order-by-col", "documentManagerCode");
					orderByType = preferences.getValue(portletName, "document-manager-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = DocumentManagerSearchUtil.getDocumentManagerOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(DocumentManagerSearch.class);

}
