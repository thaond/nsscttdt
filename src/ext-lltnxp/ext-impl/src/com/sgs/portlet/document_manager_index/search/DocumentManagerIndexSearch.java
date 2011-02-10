package com.sgs.portlet.document_manager_index.search;

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
import com.sgs.portlet.document_manager.search.DocumentManagerDisplayTerms;
import com.sgs.portlet.document_manager.util.DocumentManagerSearchUtil;

public class DocumentManagerIndexSearch extends SearchContainer<DocumentManager>{
	
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static{
		headerNames.add("stt");
		headerNames.add("document-manager-code");
		headerNames.add("document-manager-date-create");
		headerNames.add("document-manager-category");
		headerNames.add("document-manager-description");
		headerNames.add("document-manager-title");
		
		orderableHeaders.put("document-manager-code", "documentManagerCode");
		orderableHeaders.put("document-manager-category", "documentManagerCategory");
		orderableHeaders.put("document-manager-description", "documentManagerDescription");
		orderableHeaders.put("document-manager-title", "documentManagerTitle");
	}

	public static final String EMPTY_RESULTS_MESSAGE = "no-document-manager-were-found";
	
	public DocumentManagerIndexSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new DocumentManagerIndexDisplayTerms(renderRequest), new DocumentManagerIndexSearchTerms(renderRequest),
						DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			DocumentManagerIndexDisplayTerms displayTerms = (DocumentManagerIndexDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(DocumentManagerDisplayTerms.DATEFROM, displayTerms.getDateFrom());
			iteratorURL.setParameter(DocumentManagerDisplayTerms.DATETO, displayTerms.getDateTo());
			iteratorURL.setParameter(DocumentManagerIndexDisplayTerms.DOCUMENTMANAGERCODE, displayTerms.getDocumentManagerCode());
			iteratorURL.setParameter(DocumentManagerIndexDisplayTerms.DOCUMENTMANAGERCATEGORY, displayTerms.getDocumentManagerCategory());
			iteratorURL.setParameter(DocumentManagerIndexDisplayTerms.DOCUMENTMANAGERDESCRIPTION, displayTerms.getDocumentManagerDescription());
			iteratorURL.setParameter(DocumentManagerIndexDisplayTerms.DOCUMENTMANAGERTITLE, displayTerms.getDocumentManagerTitle());
			
			try {
				PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "SGS_DOCUMENT_MANAGER_INDEX";
				
				if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
					preferences.setValue(portletName, "document-manager-index-order-by-col", orderByCol);
					preferences.setValue(portletName, "document-manager-index-order-by-type", orderByType);
				} else {
					orderByCol = preferences.getValue(portletName, "document-manager-index-order-by-col", "documentManagerCode");
					orderByType = preferences.getValue(portletName, "document-manager-index-order-by-type", "asc");
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
		
		private static Log _log = LogFactoryUtil.getLog(DocumentManagerIndexSearch.class);

}
