package com.sgs.portlet.sovanbannoibo.search;

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
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.sovanbannoibo.util.PhongBanSearchUtil;

public class PhongBanSearch extends SearchContainer<Department>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static{
		headerNames.add("stt");
		headerNames.add("ma-phong-ban-van-ban-noi-bo");
		headerNames.add("ten-phong-ban-van-ban-noi-bo");
		headerNames.add("ten-viet-tat-phong-ban-van-ban-noi-bo");
		
		orderableHeaders.put("ma-phong-ban-van-ban-noi-bo", "departmentsCode");
		orderableHeaders.put("ten-phong-ban-van-ban-noi-bo", "departmentsName");
		orderableHeaders.put("ten-viet-tat-phong-ban-van-ban-noi-bo", "abbreviateName");
	}

	public static final String EMPTY_RESULTS_MESSAGE = "no-phong-ban-van-ban-noi-bo-were-found";
	
	public PhongBanSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new PhongBanDisplayTerms(renderRequest), new PhongBanSearchTerms(renderRequest),
						DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			PhongBanDisplayTerms displayTerms = (PhongBanDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(PhongBanDisplayTerms.DEPARTMENTSCODE, displayTerms.getDepartmentsCode());
			iteratorURL.setParameter(PhongBanDisplayTerms.DEPARTMENTNAMES, displayTerms.getDepartmentsName());
			iteratorURL.setParameter(PhongBanDisplayTerms.ABBREVIATENAME, displayTerms.getAbbreviateName());
			
			try {
				PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "SGS_SOVANBANNOIBO";
				
				if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {
					preferences.setValue(portletName, "phong-ban-van-ban-noi-bo-order-by-col", orderByCol);
					preferences.setValue(portletName, "phong-ban-van-ban-noi-bo-order-by-type", orderByType);
				} else {
					orderByCol = preferences.getValue(portletName, "phong-ban-van-ban-noi-bo-order-by-col", "departmentsCode");
					orderByType = preferences.getValue(portletName, "phong-ban-van-ban-noi-bo-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = PhongBanSearchUtil.getPhongBanOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(PhongBanSearch.class);
}
