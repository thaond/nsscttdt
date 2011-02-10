/**
 * 
 */
package com.sgs.portlet.onedoorsearch.searchresult;

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
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.onedoorsearch.util.PmlOneDoorReceiveFileSearchUtil;

/**
 * @author canhminh
 *
 */
public class PmlOneDoorReceiveFileSearchResult extends SearchContainer<PmlOneDoorReceiveFile>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static {
		headerNames.add("TT");
		headerNames.add("pccc-DSHS-mahoso");
		headerNames.add("pccc-TN-tenhoso");
		headerNames.add("pccc-TN-loaihoso");
		headerNames.add("pccc-DSHS-trangthaihoso");
		headerNames.add("pccc-DSHS-ngaynhan");		
		headerNames.add("pccc-DSHS-ngayhentra");
		
		orderableHeaders.put("pccc-DSHS-mahoso", "pccc-DSHS-mahoso");

	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public PmlOneDoorReceiveFileSearchResult(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(renderRequest, new PmlOneDoorReceiveFileSearchResultDisplayTerms(renderRequest),
				new PmlOneDoorReceiveFileSearchResultTerms(renderRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		PmlOneDoorReceiveFileSearchResultDisplayTerms displayTerms = (PmlOneDoorReceiveFileSearchResultDisplayTerms)getDisplayTerms();
		iteratorURL.setParameter(PmlOneDoorReceiveFileSearchResultDisplayTerms.MA_HS, displayTerms.getFileId());
		iteratorURL.setParameter(PmlOneDoorReceiveFileSearchResultDisplayTerms.TEN_HS, displayTerms.getFileName());
		iteratorURL.setParameter(PmlOneDoorReceiveFileSearchResultDisplayTerms.APPLICANTNAME, displayTerms.getApplicantName());
		iteratorURL.setParameter(PmlOneDoorReceiveFileSearchResultDisplayTerms.ADDRESS, displayTerms.getAddress());
		iteratorURL.setParameter(PmlOneDoorReceiveFileSearchResultDisplayTerms.TELEPHONE, displayTerms.getTelephone());
		iteratorURL.setParameter(PmlOneDoorReceiveFileSearchResultDisplayTerms.FILETYPE, displayTerms.getFileTypeId());
		
		iteratorURL.setParameter(PmlOneDoorReceiveFileSearchResultDisplayTerms.RECEIVEFROMDATE, displayTerms.getReceiveFromDate());
		iteratorURL.setParameter(PmlOneDoorReceiveFileSearchResultDisplayTerms.RECEIVETODATE, displayTerms.getReceiveToDate());
		iteratorURL.setParameter(PmlOneDoorReceiveFileSearchResultDisplayTerms.EXPECTRETURNINGFROMDATE, displayTerms.getExpectReturningFromDate());
		iteratorURL.setParameter(PmlOneDoorReceiveFileSearchResultDisplayTerms.EXPECTRETURNINGTODATE, displayTerms.getExpectReturningToDate() );
		iteratorURL.setParameter(PmlOneDoorReceiveFileSearchResultDisplayTerms.COMPLETEFROMDATE, displayTerms.getCompleteFromDate());
		iteratorURL.setParameter(PmlOneDoorReceiveFileSearchResultDisplayTerms.COMPLETETODATE, displayTerms.getCompleteToDate());
		iteratorURL.setParameter(PmlOneDoorReceiveFileSearchResultDisplayTerms.EXACTRETURNINGFROMDATE, displayTerms.getExactReturningFromDate());
		iteratorURL.setParameter(PmlOneDoorReceiveFileSearchResultDisplayTerms.EXACTRETURNINGTODATE, displayTerms.getExactReturningToDate());
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "SGS_ONEDOORSEARCH";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "onedoorsearch-order-by-col",	orderByCol);
				preferences.setValue(portletName, "onedoorsearch-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "onedoorsearch-order-by-col", "pccc-DSHS-mahoso");
				orderByType = preferences.getValue(portletName, "onedoorsearch-order-by-type", "desc");
			}

			OrderByComparator orderByComparator = PmlOneDoorReceiveFileSearchUtil.getPmlOneDoorReceiveFileOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PmlOneDoorReceiveFileSearchResult.class);
}
