package com.sgs.portlet.report_registry_work.search;

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
import com.sgs.portlet.report_registry_work.model.ReportRegistry;
import com.sgs.portlet.report_registry_work.util.ReportRegistrySearchUtil;


public class ReportRegistrySearch extends SearchContainer<ReportRegistry>{
	
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static{
		headerNames.add("stt");
		headerNames.add("report-registry-code");
		headerNames.add("user-create");
		headerNames.add("result-work");
		headerNames.add("program-work");
		headerNames.add("report-date");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("report-registry-code", "reportRegistryCode");
		orderableHeaders.put("user-create", "userCreate");
	}

	public static final String EMPTY_RESULTS_MESSAGE = "no-report-registry-work-were-found";
	
	public ReportRegistrySearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new ReportRegistryDisplayTerms(renderRequest), new ReportRegistrySearchTerms(renderRequest),
						DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			ReportRegistryDisplayTerms displayTerms = (ReportRegistryDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(ReportRegistryDisplayTerms.REPORTREGISTRYCODE, displayTerms.getReportRegistryCode());
			iteratorURL.setParameter(ReportRegistryDisplayTerms.USERCREATE, displayTerms.getUserCreate());
			iteratorURL.setParameter(ReportRegistryDisplayTerms.RESULTWORK, displayTerms.getResultWork());
			iteratorURL.setParameter(ReportRegistryDisplayTerms.PROGRAMWORK, displayTerms.getProgramWork());
			iteratorURL.setParameter(ReportRegistryDisplayTerms.DEPARTMENT, displayTerms.getDepartment());
			
			try {
				PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "SGS_REPORT_REGISTRY_WORK";
				
				if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
					preferences.setValue(portletName, "report-registry-work-order-by-col", orderByCol);
					preferences.setValue(portletName, "report-registry-work-order-by-type", orderByType);
				} else {
					orderByCol = preferences.getValue(portletName, "report-registry-work-order-by-col", "reportRegistryCode");
					orderByType = preferences.getValue(portletName, "report-registry-work-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = ReportRegistrySearchUtil.getReportRegistryOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(ReportRegistrySearch.class);

}
