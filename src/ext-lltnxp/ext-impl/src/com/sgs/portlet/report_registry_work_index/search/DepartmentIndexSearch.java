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
import com.sgs.portlet.report_registry_work.model.Department;
import com.sgs.portlet.report_registry_work.util.DepartmentSearchUtil;

public class DepartmentIndexSearch extends SearchContainer<Department>{
	
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static{
		headerNames.add("stt");
		headerNames.add("department-code");
		headerNames.add("department-name");
		headerNames.add("department-description");
		
		orderableHeaders.put("department-code", "departmentCode");
		orderableHeaders.put("department-name", "departmentName");
		orderableHeaders.put("department-description", "departmentDescription");
	}

	public static final String EMPTY_RESULTS_MESSAGE = "no-department-were-found";
	
	public DepartmentIndexSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new DepartmentIndexDisplayTerms(renderRequest), new DepartmentIndexSearchTerms(renderRequest),
						DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			DepartmentIndexDisplayTerms displayTerms = (DepartmentIndexDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(DepartmentIndexDisplayTerms.DEPARTMENTCODE, displayTerms.getDepartmentCode());
			iteratorURL.setParameter(DepartmentIndexDisplayTerms.DEPARTMENTNAME, displayTerms.getDepartmentName());
			iteratorURL.setParameter(DepartmentIndexDisplayTerms.DEPARTMENTDESCRIPTION, displayTerms.getDepartmentDescription());
			
			try {
				PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "SGS_REPORT_REGISTRY_WORK";
				
				if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
					preferences.setValue(portletName, "department-order-by-col", orderByCol);
					preferences.setValue(portletName, "department-order-by-type", orderByType);
				} else {
					orderByCol = preferences.getValue(portletName, "department-order-by-col", "departmentCode");
					orderByType = preferences.getValue(portletName, "department-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = DepartmentSearchUtil.getDepartmentOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(DepartmentIndexSearch.class);

}
