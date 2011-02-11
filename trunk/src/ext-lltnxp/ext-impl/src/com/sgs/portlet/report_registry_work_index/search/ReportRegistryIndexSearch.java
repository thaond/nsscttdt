package com.sgs.portlet.report_registry_work_index.search;

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
import com.sgs.portlet.report_registry_work.search.ReportRegistryDisplayTerms;
import com.sgs.portlet.report_registry_work.util.ReportRegistrySearchUtil;

public class ReportRegistryIndexSearch extends SearchContainer<ReportRegistry>{
	
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static{
		headerNames.add("stt");
		headerNames.add("report-registry-code");
		headerNames.add("user-create");
		headerNames.add("result-work");
		headerNames.add("program-work");
		headerNames.add("report-date");
		
		orderableHeaders.put("report-registry-code", "reportRegistryCode");
		orderableHeaders.put("user-create", "userCreate");
		orderableHeaders.put("result-work", "resultWork");
		orderableHeaders.put("program-work", "programWork");
	}

	public static final String EMPTY_RESULTS_MESSAGE = "no-report-registry-work-were-found";
	
	public ReportRegistryIndexSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new ReportRegistryIndexDisplayTerms(renderRequest), new ReportRegistryIndexSearchTerms(renderRequest),
						DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			ReportRegistryIndexDisplayTerms displayTerms = (ReportRegistryIndexDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(ReportRegistryIndexDisplayTerms.REPORTREGISTRYCODE, displayTerms.getReportRegistryCode());
			iteratorURL.setParameter(ReportRegistryIndexDisplayTerms.USERCREATE, displayTerms.getUserCreate());
			iteratorURL.setParameter(ReportRegistryIndexDisplayTerms.RESULTWORK, displayTerms.getResultWork());
			iteratorURL.setParameter(ReportRegistryIndexDisplayTerms.PROGRAMWORK, displayTerms.getProgramWork());
			iteratorURL.setParameter(ReportRegistryDisplayTerms.DEPARTMENT, String.valueOf(displayTerms.getDepartment()));
			iteratorURL.setParameter(ReportRegistryDisplayTerms.DATEFROM, displayTerms.getDateFrom());
			iteratorURL.setParameter(ReportRegistryDisplayTerms.DATETO, displayTerms.getDateTo());
			
			try {
				PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "SGS_REPORT_REGISTRY_WORK_INDEX";
				
				if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
					preferences.setValue(portletName, "report-registry-work-index-order-by-col", orderByCol);
					preferences.setValue(portletName, "report-registry-work-index-order-by-type", orderByType);
				} else {
					orderByCol = preferences.getValue(portletName, "report-registry-work-index-order-by-col", "reportRegistryCode");
					orderByType = preferences.getValue(portletName, "report-registry-work-index-order-by-type", "asc");
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
		
		private static Log _log = LogFactoryUtil.getLog(ReportRegistryIndexSearch.class);

}
