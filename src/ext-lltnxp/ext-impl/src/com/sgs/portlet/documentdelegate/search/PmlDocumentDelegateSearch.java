/**
 * 
 */
package com.sgs.portlet.documentdelegate.search;

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
import com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate;
import com.sgs.portlet.documentdelegate.util.PmlDocumentDelegateUtil;

/**
 * @author WIN7
 *
 */
public class PmlDocumentDelegateSearch extends SearchContainer<PmlDocumentDelegate> {
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("pccc-TN-stt");
		headerNames.add("nguoi-uy-quyen");
		headerNames.add("nguoi-duoc-uy-quyen");
		headerNames.add("ngay-bat-dau-uy-quyen");
		headerNames.add("ngay-ket-thuc-uy-quyen");
		headerNames.add("ngay-ngung-uy-quyen");
		headerNames.add("");
		
		orderableHeaders.put("nguoi-uy-quyen", "nguoi-uy-quyen");
		orderableHeaders.put("ngay-bat-dau-uy-quyen", "ngay-bat-dau-uy-quyen");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public PmlDocumentDelegateSearch(RenderRequest renderRequest, PortletURL iteratorURL){
			super(renderRequest, new PmlDocumentDelegateDisplayTerms(renderRequest), new PmlDocumentDelegateSearchTerms(renderRequest),
					DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
			
			PmlDocumentDelegateDisplayTerms displayTerms = (PmlDocumentDelegateDisplayTerms)getDisplayTerms();
			
			iteratorURL.setParameter(PmlDocumentDelegateDisplayTerms.USER_DELEGATE, String.valueOf(displayTerms.getUserDelegate()));
			iteratorURL.setParameter(PmlDocumentDelegateDisplayTerms.LIST_USER_IS_DELEGATE, displayTerms.getListUserIsDelegate());
			iteratorURL.setParameter(PmlDocumentDelegateDisplayTerms.FROM_DATE_DELEGATE, displayTerms.getFromDateDelegate());
			iteratorURL.setParameter(PmlDocumentDelegateDisplayTerms.TO_DATE_DELEGATE, displayTerms.getToDateDelegate());
			iteratorURL.setParameter(PmlDocumentDelegateDisplayTerms.CHECK_ALL_USER, String.valueOf(displayTerms.isCheckAllUser()));
			
			try {
				PortalPreferences preferences =
					PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

				String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
				String orderByType = ParamUtil.getString(renderRequest, "orderByType");

				String portletName = "SGS_DOCUMENTDELEGATE";
				
				if (Validator.isNotNull(orderByCol) &&
					Validator.isNotNull(orderByType)) {

					preferences.setValue(portletName, "documentdelegate-order-by-col", orderByCol);
					preferences.setValue(portletName, "documentdelegate-order-by-type", orderByType);
				}
				
				else {
					orderByCol = preferences.getValue(portletName, "documentdelegate-order-by-col", "ngay-bat-dau-uy-quyen");
					orderByType = preferences.getValue(portletName, "documentdelegate-order-by-type", "asc");
				}

				OrderByComparator orderByComparator = PmlDocumentDelegateUtil.getPmlDepartmentOrderByComparator(orderByCol, orderByType);

				setOrderableHeaders(orderableHeaders);
				setOrderByCol(orderByCol);
				setOrderByType(orderByType);
				setOrderByComparator(orderByComparator);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
		
		private static Log _log = LogFactoryUtil.getLog(PmlDocumentDelegateSearch.class);
}
