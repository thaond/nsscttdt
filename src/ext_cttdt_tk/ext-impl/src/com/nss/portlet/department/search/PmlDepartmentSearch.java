/**
 * 
 */
package com.nss.portlet.department.search;

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
import com.nss.portlet.department.model.Department;
import com.nss.portlet.department.util.PmlDepartmentSearchUtil;

public class PmlDepartmentSearch extends SearchContainer<Department> {
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("department_code");
		headerNames.add("department_name");
		headerNames.add("abbreviate_name");
		headerNames.add("department_phutrach");
		headerNames.add("description");
		headerNames.add("lanh_dao_phong");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("department_code", "department_code");
		orderableHeaders.put("department_name", "department_name");
		orderableHeaders.put("abbreviate_name", "abbreviate_name");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public PmlDepartmentSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new PmlDepartmentDisplayTerms(renderRequest), new PmlDepartmentSearchTerms(renderRequest),
					DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			PmlDepartmentDisplayTerms displayTerms = (PmlDepartmentDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(PmlDepartmentDisplayTerms.MA_PHONG, displayTerms.getMaPhong());
			iteratorURL.setParameter(PmlDepartmentDisplayTerms.TEN_PHONG, displayTerms.getTenPhong());
			iteratorURL.setParameter(PmlDepartmentDisplayTerms.TEN_VIET_TAT, displayTerms.getTenVietTat());
			
			try {
				PortalPreferences preferences =
					PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "NSS_DEPARTMENTLEADER";
				
				if (Validator.isNotNull(orderByCol) &&
					Validator.isNotNull(orderByType)) {

					preferences.setValue(portletName, "departmentleader-order-by-col", orderByCol);
					preferences.setValue(portletName, "departmentleader-order-by-type", orderByType);
				}
				
				else {
					orderByCol = preferences.getValue(portletName, "departmentleader-order-by-col", "department_code");
					orderByType = preferences.getValue(portletName, "departmentleader-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = PmlDepartmentSearchUtil.getPmlDepartmentOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(PmlDepartmentSearch.class);
}
