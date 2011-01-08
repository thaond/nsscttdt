package com.sgs.portlet.congvandidahoanthanh.search;

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
import com.sgs.portlet.congvandidahoanthanh.util.CVDiDaHoanThanhUtil;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;

public class CVDiDaHoanThanhSearch extends SearchContainer<PmlEdmDocumentSend> {
	
	static List<String> headernames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headernames.add("STT");
		headernames.add("ngayphathanh");
		headernames.add("noidung");
		headernames.add("loaicongvan");
		headernames.add("nguoikyvanban");
		headernames.add("nguoisoanvanban");
		headernames.add("noinhan");
		headernames.add("nguoitheodoi");
		headernames.add("ghichu");
		
		orderableHeaders.put("ngayphathanh", "ngayphathanh");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public CVDiDaHoanThanhSearch (RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new CVDiDaHoanThanhDisplayTerms(renderRequest), new CVDiDaHoanThanhSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
		
		CVDiDaHoanThanhDisplayTerms displayTerms = (CVDiDaHoanThanhDisplayTerms)getDisplayTerms();
		
		iteratorURL.setParameter(CVDiDaHoanThanhDisplayTerms.FROMDATE, String.valueOf(displayTerms.getFromDate()));
		iteratorURL.setParameter(CVDiDaHoanThanhDisplayTerms.TODATE, String.valueOf(displayTerms.getToDate()));
		
		String[] loaiSoCongVan = new String [displayTerms.getLoaiSoCongVan().length];
		for (int i = 0; i < displayTerms.getLoaiSoCongVan().length; i++) {
			loaiSoCongVan[i] = String.valueOf(displayTerms.getLoaiSoCongVan()[i]);
		}
		iteratorURL.setParameter(CVDiDaHoanThanhDisplayTerms.LOAISOCONGVAN, loaiSoCongVan);
		
		try {
			PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "SGS_CONGVANDIDAHOANTHANH";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "cvdi-order-by-col",	orderByCol);
				preferences.setValue(portletName, "cvdi-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "cvdi-order-by-col", "ngayphathanh");
				orderByType = preferences.getValue(portletName, "cvdi-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = CVDiDaHoanThanhUtil.getPhanTichOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(CVDiDaHoanThanhSearch.class);
	
}
