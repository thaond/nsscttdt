package com.nss.portlet.managementworkflowjournal.search;

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
import com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal;
import com.nss.portlet.managementworkflowjournal.util.ManagementWorkflowJournalSearchUtil;

public class ManagementWorkflowJournalSearch extends SearchContainer<ManagementWorkflowJournal>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("name");
		headerNames.add("version");
		headerNames.add("description");
		headerNames.add("dateFrom");
		headerNames.add("dateTo");
		headerNames.add("");
		
		
		orderableHeaders.put("version", "version");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public ManagementWorkflowJournalSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new ManagementWorkflowJournalDisplayTerms(renderRequest), new ManagementWorkflowJournalSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "NSS_MANAGEMENTWORKFLOWJOURNAL";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "ManagementWorkflowJournal-order-by-col", orderByCol);
				preferences.setValue(portletName, "ManagementWorkflowJournal-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "ManagementWorkflowJournal-order-by-col", "version");
				orderByType = preferences.getValue(portletName, "ManagementWorkflowJournal-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = ManagementWorkflowJournalSearchUtil.getManagementWorkflowJournalOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(ManagementWorkflowJournalSearch.class);
}
