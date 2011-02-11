/**
 * 
 */
package com.sgs.portlet.pmluser.search;

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
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.util.PmlUserUtil;

/**
 * @author minhnv
 *
 */
public class PmlUserSearch extends SearchContainer<PmlUser> {
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static{
		headerNames.add("pccc-TN-stt");
		headerNames.add("screen-name");
		headerNames.add("full-name");
		headerNames.add("email");
		headerNames.add("receipt.position");
		headerNames.add("department_name");
		headerNames.add("description");		
		headerNames.add("edit");
		headerNames.add("sgs_field_delete");
		
		orderableHeaders.put("screen-name", "screen-name");
		orderableHeaders.put("full-name", "full-name");
		orderableHeaders.put("receipt.position", "receipt.position");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public PmlUserSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new PmlUserDisplayTerms(renderRequest), new PmlUserSearchTerms(renderRequest),
						DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			PmlUserDisplayTerms displayTerms = (PmlUserDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(PmlUserDisplayTerms.TEN_GOI, displayTerms.getTenGoi());
			iteratorURL.setParameter(PmlUserDisplayTerms.HO, displayTerms.getHo());
			iteratorURL.setParameter(PmlUserDisplayTerms.LOT, displayTerms.getLot());
			iteratorURL.setParameter(PmlUserDisplayTerms.TEN, displayTerms.getTen());
			iteratorURL.setParameter(PmlUserDisplayTerms.CHUC_VU, displayTerms.getChucVu());
			
			try {
				PortalPreferences preferences =
					PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "SGS_PMLUSER";
				
				if (Validator.isNotNull(orderByCol) &&
					Validator.isNotNull(orderByType)) {

					preferences.setValue(portletName, "pmluser-order-by-col", orderByCol);
					preferences.setValue(portletName, "pmluser-order-by-type", orderByType);
				}
				
				else {
					orderByCol = preferences.getValue(portletName, "pmluser-order-by-col", "screen-name");
					orderByType = preferences.getValue(portletName, "pmluser-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = PmlUserUtil.getPmlUserOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(PmlUserSearch.class);
}
