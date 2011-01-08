package com.sgs.portlet.home_report.search;

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
import com.sgs.portlet.home_report.util.HomeReportUtil;
import com.sgs.portlet.pmluser.model.PmlUser;

public class HomeReportSearch extends SearchContainer<PmlUser> {

	static List<String> headernames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static{
		headernames.add("STT");
		headernames.add("ho-ten");
		headernames.add("ton-thang-truoc");
		headernames.add("nhan-trong-thang");
		headernames.add("da-xu-ly");
		headernames.add("con-ton");
		
		orderableHeaders.put("ho-ten", "hoten");
	}
	

	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";

	public HomeReportSearch(RenderRequest renderRequest,
			PortletURL iteratorURL) {
		super(renderRequest, new HomeReportDisplayTerms(renderRequest),
				new HomeReportSearchTerms(renderRequest), DEFAULT_CUR_PARAM, 
				10, iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
		
		HomeReportDisplayTerms displayTerms = (HomeReportDisplayTerms)getDisplayTerms();
	
		iteratorURL.setParameter(HomeReportDisplayTerms.DEPARTMENTID, String.valueOf(displayTerms.getDepartmentId()));
		iteratorURL.setParameter(HomeReportDisplayTerms.USERID, String.valueOf(displayTerms.getUserId()));
		iteratorURL.setParameter(HomeReportDisplayTerms.LOAITHONGKE, String.valueOf(displayTerms.getLoaiThongKe()));
		iteratorURL.setParameter(HomeReportDisplayTerms.FROMDATE, String.valueOf(displayTerms.getFromDate()));
		iteratorURL.setParameter(HomeReportDisplayTerms.TODATE, String.valueOf(displayTerms.getToDate()));
		
		try {
			 PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);
			 
			 String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			 String orderByType = ParamUtil.getString(renderRequest, "orderByType");
			 
			 if(Validator.isNotNull(orderByCol)&& Validator.isNotNull(orderByType)){
				 preferences.setValue("SGS_HOME_REPORT", "home-report-document-order-by-type", orderByCol);
				 preferences.setValue("SGS_HOME_REPORT", "home-report-document-order-by-type", orderByType);
			 }
			 else{
				 preferences.setValue("SGS_HOME_REPORT", "home-report-document-order-by-column", "hoten");
				 preferences.setValue("SGS_HOME_REPORT", "home-report-document-order-by-type", "asc");
			 }
			 
			 OrderByComparator orderByComparator = HomeReportUtil.getHomeReportOrderByComparator(orderByCol, orderByType);
			 setOrderableHeaders(orderableHeaders);
			 setOrderByCol(orderByCol);
			 setOrderByType(orderByType);
			 setOrderByComparator(orderByComparator);

		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	private Log _log = LogFactoryUtil.getLog(HomeReportSearch.class);
}
