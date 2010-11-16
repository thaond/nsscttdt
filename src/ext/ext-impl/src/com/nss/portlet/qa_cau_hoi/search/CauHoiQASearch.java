package com.nss.portlet.qa_cau_hoi.search;

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
import com.nss.portlet.qa_cau_hoi.model.CauHoiQA;
import com.nss.portlet.qa_cau_hoi.util.QACauHoiSearchUtil;

public class CauHoiQASearch extends SearchContainer<CauHoiQA>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("tieu-de-cau-hoi");
		headerNames.add("nguoi-hoi");
		headerNames.add("ngay-hoi");
		headerNames.add("trang-thai");
		
		orderableHeaders.put("tieu-de-cau-hoi", "tieuDeCauHoi");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	public CauHoiQASearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new CauHoiQADisplayTerms(renderRequest), new CauHoiQASearchTerms(renderRequest),
				DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		CauHoiQADisplayTerms displayTerms = (CauHoiQADisplayTerms)getDisplayTerms();
		
		iteratorURL.setParameter(CauHoiQADisplayTerms.TIEU_DE_CAU_HOI, displayTerms.getTieuDeCauHoi());
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "NSS_QA_CAU_HOI";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "qaCauHoi-order-by-col", orderByCol);
				preferences.setValue(portletName, "qaCauHoi-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "qaCauHoi-order-by-col", "tieuDeCauHoi");
				orderByType = preferences.getValue(portletName, "qaCauHoi-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = QACauHoiSearchUtil.getTieuDeCauHoiOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(CauHoiQASearch.class);
}
