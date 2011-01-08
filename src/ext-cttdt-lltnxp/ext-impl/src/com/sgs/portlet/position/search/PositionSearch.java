package com.sgs.portlet.position.search;

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
import com.sgs.portlet.position.model.Position;
import com.sgs.portlet.position.util.PositionSearchUtil;

public class PositionSearch extends SearchContainer<Position>{
	
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static{
		headerNames.add("no.");
		headerNames.add("code.");
		headerNames.add("name.");
		headerNames.add("description.");
		headerNames.add("active.");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("code.", "code");
		orderableHeaders.put("name.", "name");
		orderableHeaders.put("description.", "description");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public PositionSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new PositionDisplayTerms(renderRequest), new PositionSearchTerms(renderRequest),
						DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			PositionDisplayTerms displayTerms = (PositionDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(PositionDisplayTerms.MA, displayTerms.getMa());
			iteratorURL.setParameter(PositionDisplayTerms.TEN, displayTerms.getTen());
			iteratorURL.setParameter(PositionDisplayTerms.MOTA, displayTerms.getMoTa());
			
			try {
				PortalPreferences preferences =
					PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "SGS_POSITION";
				
				if (Validator.isNotNull(orderByCol) &&
					Validator.isNotNull(orderByType)) {

					preferences.setValue(portletName, "position-order-by-col", orderByCol);
					preferences.setValue(portletName, "position-order-by-type", orderByType);
				}
				
				else {
					orderByCol = preferences.getValue(portletName, "position-order-by-col", "code");
					orderByType = preferences.getValue(portletName, "position-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = PositionSearchUtil.getPositionOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(PositionSearch.class);

}
