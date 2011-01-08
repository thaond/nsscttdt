package com.sgs.portlet.attachedfile.search;

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
import com.sgs.portlet.attachedfile.model.AttachedFile;
import com.sgs.portlet.attachedfile.util.AttachedfileUtil;

public class AttachedfileSearch extends SearchContainer<AttachedFile>{
	
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("code.");
		headerNames.add("pccc-TN-tenhosodinhkem");
		headerNames.add("description.");
		headerNames.add("active.");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("code.", "code");
		orderableHeaders.put("pccc-TN-tenhosodinhkem", "name");
		
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public AttachedfileSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new AttachedfileDisplayTerms(renderRequest), new AttachedfileSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		AttachedfileDisplayTerms displayTerms = (AttachedfileDisplayTerms) getDisplayTerms();
		iteratorURL.setParameter(AttachedfileDisplayTerms.MA, displayTerms.getMa());
		iteratorURL.setParameter(AttachedfileDisplayTerms.TEN, displayTerms.getTen());
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "SGS_ATTACHEDFILE";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "attachedfile-order-by-col", orderByCol);
				preferences.setValue(portletName, "attachedfile-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "attachedfile-order-by-col", "code");
				orderByType = preferences.getValue(portletName, "attachedfile-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = AttachedfileUtil.getAttachedfileOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(AttachedfileSearch.class);


}
