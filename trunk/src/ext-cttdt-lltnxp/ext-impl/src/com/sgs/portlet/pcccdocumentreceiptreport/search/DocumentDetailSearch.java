package com.sgs.portlet.pcccdocumentreceiptreport.search;

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
import com.sgs.portlet.pcccdocumentreceiptreport.dto.PCCCDocumentListDTO;

public class DocumentDetailSearch extends SearchContainer<PCCCDocumentListDTO> {

	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static {
		headerNames.add("sgs_onedoor_no.");
		headerNames.add("so-den-theo-so");
		headerNames.add("so-ky-hieu-goc");
		headerNames.add("loai-van-ban");
		headerNames.add("pccc-TN-ngaynhan");
		headerNames.add("ngayphathanh");
		headerNames.add("noiphathanh");
		headerNames.add("document_brief_content");
		headerNames.add("pccc-cvdtn-domat");
		headerNames.add("report-chuyenviendangxuly");
		
		orderableHeaders.put("pccc-cvdtn-domat", "pccc-cvdtn-domat");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "documentreceipt-search-khongtontaidulieu";

	public DocumentDetailSearch(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(renderRequest, new DocumentDetailDisplayTerms(renderRequest),
				new DocumentDetailSearchTerms(renderRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		DocumentDetailDisplayTerms displayTerms = (DocumentDetailDisplayTerms)getDisplayTerms();
		
		iteratorURL.setParameter(DocumentDetailDisplayTerms.DEPARTMENTID, String.valueOf(displayTerms.getDepartmentId()));
		iteratorURL.setParameter(DocumentDetailDisplayTerms.USERID, String.valueOf(displayTerms.getUserId()));
		iteratorURL.setParameter(DocumentDetailDisplayTerms.NHOMCONGVAN, String.valueOf(displayTerms.getNhomCongVan()));
		iteratorURL.setParameter(DocumentDetailDisplayTerms.LOAICONGVAN, String.valueOf(displayTerms.getLoaiCongVan()));
		iteratorURL.setParameter(DocumentDetailDisplayTerms.DOMAT, String.valueOf(displayTerms.getDoMat()));
		iteratorURL.setParameter(DocumentDetailDisplayTerms.FROMDATE, String.valueOf(displayTerms.getFromDate()));
		iteratorURL.setParameter(DocumentDetailDisplayTerms.TODATE, String.valueOf(displayTerms.getToDate()));
		iteratorURL.setParameter(DocumentDetailDisplayTerms.CAPGUI, String.valueOf(displayTerms.getCapgui()));
		iteratorURL.setParameter(DocumentDetailDisplayTerms.LOAISOCONGVAN, String.valueOf(displayTerms.getLoaisocongvan()));
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "pccc-cvdtn-domat");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType", "asc");

			String portletName = "SGS_PCCCDOCUMENTRECEIPTREPORT";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "documentdetail-order-by-col", orderByCol);
				preferences.setValue(portletName, "documentdetail-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "documentdetail-order-by-col", "pccc-cvdtn-domat");
				orderByType = preferences.getValue(portletName, "documentdetail-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = DocumentDetailUtil.getDocumentDetailOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(DocumentDetailSearch.class);

}
