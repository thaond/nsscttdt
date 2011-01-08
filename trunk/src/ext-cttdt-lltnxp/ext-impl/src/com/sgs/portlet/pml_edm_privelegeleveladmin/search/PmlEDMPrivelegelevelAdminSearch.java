/**
 * 
 */
package com.sgs.portlet.pml_edm_privelegeleveladmin.search;

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
import com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel;
import com.sgs.portlet.pml_edm_privelegeleveladmin.util.PmlEdmPrivilegeLevelUtil;


/**
 * @author minhnv
 *
 */
public class PmlEDMPrivelegelevelAdminSearch extends SearchContainer<PmlEdmPrivilegeLevel>{
	static List<String> headernames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headernames.add("pccc-TN-stt");
		headernames.add("pml_edm_privilege_level_id");
		headernames.add("pml_edm_privilege_level_name");
		headernames.add("");
		
		orderableHeaders.put("pml_edm_privilege_level_name", "pml_edm_privilege_level_name");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public PmlEDMPrivelegelevelAdminSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new PmlEDMPrivelegelevelAdminDisplayTerms (renderRequest),
				new PmlEDMPrivelegelevelAdminSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM, DEFAULT_DELTA,
				iteratorURL, headernames, EMPTY_RESULTS_MESSAGE);
				
		PmlEDMPrivelegelevelAdminDisplayTerms displayTerms = (PmlEDMPrivelegelevelAdminDisplayTerms)getDisplayTerms();
		
		iteratorURL.setParameter(PmlEDMPrivelegelevelAdminDisplayTerms.PRIVILEGELEVEL_NAME, displayTerms.getPrivilegelevelName());
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "SGS_PML_EDM_PRIVELEGELEVELADMIN";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "pmledmprivilegelevelworks-order-by-col",	orderByCol);
				preferences.setValue(portletName, "pmledmprivilegelevelworks-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "pmledmprivilegelevelworks-order-by-col", "pml_edm_privilege_level_name");
				orderByType = preferences.getValue(portletName, "pmledmprivilegelevelworks-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = PmlEdmPrivilegeLevelUtil.getPmlEdmPrivilegeLevelOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private final Log _log = LogFactoryUtil.getLog(PmlEDMPrivelegelevelAdminSearch.class);
}
